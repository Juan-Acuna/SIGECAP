(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded', ()=>{
        const idCap =Number.parseInt( document.getElementById('dejack').getAttribute('data-cap-id'));
        const agenda = document.querySelector("#agenda-front");
        const form = document.querySelector('form');
        const txtAgenda = document.querySelector('#txtAgenda');
        const submit = document.querySelector('#btnSubmit');
        const DESTACADO ='#3e4';
        const DESTACADO_ERROR = '#b44';
        let fechaAnterior = '';
        let eventos = [];
        let ocupado = [];
        let neventos = 0;
        function generarEvento(inicio, duracion, offset, destacado = false){
            let h = Number.parseInt(inicio.substring(11,13)) - 8;
            let horas = 0;
            if(typeof duracion === 'string'){
                horas = calcularHoras(inicio, duracion);
            }else{
                horas = duracion;
            }
            var div = document.createElement('div');
            div.style.backgroundColor = destacado?DESTACADO:"#accdff";
            div.style.border = "1px solid #999";
            div.style.width = "32px";
            div.style.position = "absolute";
            div.style.height = (horas * 35)+"px";
            div.style.top = (h*35)+"px";
            div.style.left = ((offset*33)+51)+"px";
            if(destacado){
                var actual = document.querySelector('#evento-destacado');
                if(actual){
                    actual.remove();
                }
                submit.removeAttribute('disabled');
                for (let i = h; i < horas+h; i++) {
                    if(ocupado[i]){
                        div.style.backgroundColor = DESTACADO_ERROR;
                        submit.setAttribute('disabled','disabled');
                        break;
                    }
                }
                div.id = 'evento-destacado';
            } else {
                for (let i = h; i < horas+h; i++) {
                    ocupado[i] = true;
                }
            }
            agenda.appendChild(div);
        }
        let actualizarAgenda = ()=>{
            let hora = Number.parseInt(form['hora'].value.substring(0,3));
            if(hora>16){
                form['hora'].value = '16:00';
                hora = 16;
            } else if(hora<8){
                form['hora'].value = '08:00';
                hora = 8;
            }
            form['duracion'].max = 9 - (hora - 8);
            if(form['duracion'].value>form['duracion'].max){
                form['duracion'].value = form['duracion'].max;
            }
            if(fechaAnterior!=form['fecha'].value){
                fechaAnterior = form['fecha'].value;
                txtAgenda.innerText = fechaAnterior;
                neventos = 0;
                ocupado = [];
                agenda.innerHTML = '';
                var actual = document.querySelector('#evento-destacado');
                if(actual){
                    actual.remove();
                }
                get('/api/v1/capacitaciones/fecha/'+fechaAnterior+'T00:00', (data)=>{
                    if(data.status==200){
                        eventos = data.contenido;
                        eventos.forEach(e => {
                            if(idCap!=e.id){
                                generarEvento(e.inicio, e.fin, neventos);
                                neventos++;
                            }
                        });
                    }else{
                        console.log(data.contenido.error);
                    }
                    generarEvento(form['fecha'].value + 'T' + form['hora'].value, Number.parseInt(form['duracion'].value), neventos, true);
                });
            }else{
                generarEvento(form['fecha'].value + 'T' + form['hora'].value, Number.parseInt(form['duracion'].value), neventos, true);
            }
        }
        form.onsubmit = (event)=>{
            event.preventDefault();
            let capacitacion = {
                id: idCap,
                titulo: form['titulo'].value,
                descripcion: form['descripcion'].value,
                inicio: form['fecha'].value + 'T' + form['hora'].value,
                fin: calcularFecha(form['fecha'].value + 'T'+ form['hora'].value, form['duracion'].value),
                maxAlumnos: Number.parseInt(form['maxAlumnos'].value),
                maxTutores: Number.parseInt(form['maxTutores'].value),
                ubicacion: {
                    id: form['ubi'].value,
                    nombre: form['ubi'].innerText
                },
            };
            patch(form.action, capacitacion, (data) => {
                if(data.status==200){
                    alert("Se actualizo la capacitacion");
                    reload();
                }else{
                    alert(data.contenido.error);
                }
            });
        };
        form['fecha'].onchange = actualizarAgenda;
        form['hora'].onchange = actualizarAgenda;
        form['duracion'].onchange = actualizarAgenda;
        form['fecha'].value = extraerFecha(form['fecha_inicio'].value);
        form['hora'].value = extraerHora(form['fecha_inicio'].value);
        form['duracion'].value = calcularHoras(form['fecha_inicio'].value, form['fecha_fin'].value);
        actualizarAgenda();
    });
})();