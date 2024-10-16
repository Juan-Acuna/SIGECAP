(()=>{
    "use strict";
    let nuevoUsuario = (id, nombres, email)=>{
        return {
            id : id,
            nombres : nombres,
            email : email
        }
    };
    class Lista{
        constructor(elemento, max=-1, disponible=true){
            this.elemento=document.getElementById(elemento);
            this.hermano=null;
            this.lista=[];
            this.max=max;
            this.disponible=disponible;
            this.setVacio();
        }
        agregarVarios(usuarios){
            usuarios.forEach(u=>{
                this.agregar(nuevoUsuario(u.id, u.nombres+' '+u.apellidos, u.email));
            });
        }
        agregar(usuario){
            if(this.max!=-1 && this.max<this.lista.length+1)
                return false;
            if(this.lista.length===0)
                document.querySelector('#'+this.elemento.id+' li').remove();
            this.lista.push(usuario);
            this.elemento.appendChild(this.crearItem(usuario));
            return true;
        }
        quitar(usuario){
            document.querySelector('#u'+usuario.id).remove();
             this.lista.splice(this.lista.indexOf(usuario), 1);
            if(this.lista.length==0)
                this.setVacio();
        }
        extraer(){
            let l = [...this.lista];
            this.lista.splice(0, this.lista.length);
            this.setVacio();
            return l;
        }
        crearItem(usuario){
            let e = document.createElement('li');
            let nombres = document.createElement('span');
            let email = document.createElement('span');
            let btn = document.createElement('button');
            e.classList.add('list-group-item', 'd-flex', 'justify-content-between', 'align-items-center');
            e.setAttribute('id','u'+usuario.id);
            nombres.innerText = usuario.nombres;
            email.innerText = usuario.email;
            email.classList.add('text-muted');
            btn.innerHTML = '<i class="bi bi-'+(this.disponible?'plus':'x')+'"></i>';
            btn.classList.add('btn','btn-sm','btn-primary');
            btn.setAttribute('data-id',usuario.id);
            btn.setAttribute('data-nombres',usuario.nombres);
            btn.setAttribute('data-email',usuario.email);
            e.appendChild(nombres);
            e.appendChild(email);
            e.appendChild(btn);
            let t = this;
            btn.addEventListener('click', function(evento){
                t.quitar(usuario);
                t.hermano.agregar(usuario);
            });
            return e;
        }
        setHermano(hermano){
            this.hermano=hermano;
            if(this.disponible)
                this.hermano.setHermano(this);
        }
        setVacio(){
            this.elemento.innerHTML = '<li class="list-group-item d-flex justify-content-between align-items-center"><span class="pt-1 pb-1">'+(this.disponible?'No hay usarios disponibles':'Ningún usuario agregado aún')+'</span></li>';
        }
        reset(){
            if(!this.disponible)
                this.lista.forEach(u=>{
                    this.quitar(u);
                    this.hermano.agregar(u);
            })
        }
    }
    let modal = {};
    let capacitacion = {};
    document.addEventListener('DOMContentLoaded',()=>{
        let dataDiv = document.querySelector('#dejack');
        let contadorAlumnos = document.getElementById('contador-a');
        let contadorTutores = document.getElementById('contador-t');
        capacitacion = {
            id : dataDiv.getAttribute('data-cap-id'),
            tutores : Number.parseInt(dataDiv.getAttribute('data-init-t')),
            alumnos : Number.parseInt(dataDiv.getAttribute('data-init-a')),
            maxTutores : Number.parseInt(dataDiv.getAttribute('data-max-t')),
            maxAlumnos : Number.parseInt(dataDiv.getAttribute('data-max-a'))
        };
        modal = {
            alumnos : {
                disponibles : new Lista('dis-alumnos',),
                agregados : new Lista('agr-alumnos', capacitacion.maxAlumnos-capacitacion.alumnos, false)
            },
            tutores : {
                disponibles : new Lista('dis-tutores'),
                agregados : new Lista('agr-tutores', capacitacion.maxTutores-capacitacion.tutores, false)
            }
        }
        let fnQuitarUsuario = async function(event){
            let contid = event.currentTarget.getAttribute('data-cont-id');
            let usuario = {
                id : event.currentTarget.getAttribute('data-id'),
                nombres : event.currentTarget.getAttribute('data-nombres'),
                email : event.currentTarget.getAttribute('data-email')
            }
            //se quita el usuario de la capacitacion;
            await del('/api/v1/capacitaciones/'+capacitacion.id+'/usuarios/quitar/'+usuario.email, function(data){
                if(data.status===200){
                    if(contid.startsWith('tutor')){
                        modal.tutores.disponibles.agregar(usuario);
                        capacitacion.tutores = capacitacion.tutores -1;
                        contadorTutores.innerText = capacitacion.tutores;
                    }else{
                        modal.alumnos.disponibles.agregar(usuario);
                        capacitacion.alumnos = capacitacion.alumnos -1;
                        contadorAlumnos.innerText = capacitacion.alumnos;
                    }
                    document.getElementById(contid).remove();
                }else{
                    console.log(data.contenido);
                    console.log(data.contenido.error);
                }
            });
        }
        let fnGuardar = async function(evento, rol){
            let plural = rol+(rol[rol.length-1]==='r'?'es':'s');
            let lista = modal[plural].agregados.extraer();
            let cont = document.getElementById('cont-'+plural);
            lista.forEach(u=>{
                var el = document.createElement('div');
                el.setAttribute('id',rol+'-'+u.id);
                el.classList.add('d-flex', 'justify-content-between', 'align-items-center', 'pt-1', 'pb-1');
                el.innerHTML = '<div class="w-100 d-flex justify-content-between align-items-center pe-5"><span>'+u.nombres+'</span><span class="text-muted">'+u.email+'</span></div>' ;
                var btn = document.createElement('button');
                btn.classList.add('btn', 'btn-sm', 'btn-outline-danger');
                btn.setAttribute('data-cont-id',rol+'-'+u.id);
                btn.setAttribute('data-id',u.id);
                btn.setAttribute('data-nombres',u.nombres);
                btn.setAttribute('data-email',u.email);
                btn.innerHTML = '<i class="bi bi-x"></i>';
                btn.addEventListener('click', fnQuitarUsuario);
                el.appendChild(btn);
                cont.append(el);
            });
            if(rol === 'tutor'){
                capacitacion.tutores = capacitacion.tutores + lista.length;
                contadorTutores.innerText = capacitacion.tutores;
            }else{
                capacitacion.alumnos = capacitacion.alumnos + lista.length;
                contadorAlumnos.innerText = capacitacion.alumnos;
            }
            //se agregan los usuarios;
            await post('/api/v1/capacitaciones/'+capacitacion.id+'/agregar', lista, (data)=>{
                if(data.status===200){
                    console.log('Realizado.');
                }else{
                    console.log(data.contenido);
                    console.log(data.contenido.error);
                }
            });
        }
        modal.alumnos.disponibles.setHermano(modal.alumnos.agregados);
        modal.tutores.disponibles.setHermano(modal.tutores.agregados);
        //AQUI SE CARGAN LOS DATOS
        get('/api/v1/usuarios/filtrados/'+capacitacion.id, (data)=>{
            if(data.status==200){
                if(data.contenido.alumnos.length===0){
                    modal.alumnos.disponibles.setVacio();
                }else{
                    modal.alumnos.disponibles.agregarVarios(data.contenido.alumnos);
                }
                if(data.contenido.tutores.length===0){
                    modal.tutores.disponibles.setVacio();
                }else{
                    modal.tutores.disponibles.agregarVarios(data.contenido.tutores);
                }
            }else{
                console.log(data.contenido);
            }
        });
        document.getElementById('btn-guardar-t').addEventListener('click', function(event){ fnGuardar(event, 'tutor'); });
        document.getElementById('btn-guardar-a').addEventListener('click', function(event){ fnGuardar(event, 'alumno'); });
        document.getElementById('tutoresModal').addEventListener('hidden.bs.modal',function(event){
            modal.tutores.agregados.reset();
        });
        document.getElementById('alumnosModal').addEventListener('hidden.bs.modal',function(event){
            modal.alumnos.agregados.reset();
        });
        document.querySelectorAll('.usuario-from-cap').forEach(b=>{
            b.addEventListener('click', fnQuitarUsuario);
        });
    });
})();