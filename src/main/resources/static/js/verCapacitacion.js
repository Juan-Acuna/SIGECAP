(()=>{
    "use strict";
    let calificacionObj = {
        usuario: '',
        nota: 0.0,
        comentarios:'',
    };
    let modal = {
        titulo:null,
        comentarios:null,
        nota:null,
        calificacion:calificacionObj,
        target:null,
        notaLabel:null,
        setData:function(target){
            this.target=target;
            this.titulo.innerText = 'Calificar alumno: '+target.getAttribute('data-nombres');
            this.comentarios.value = target.getAttribute('data-comentarios');
            this.nota.value = target.getAttribute('data-nota');
            this.calificacion.usuario = target.getAttribute('data-email');
            var id = target.getAttribute('data-label-id');
            this.notaLabel = document.getElementById(id);
            console.log(id);
            console.log(this.notaLabel);
        },
        calificar:function(){
            this.calificacion.comentarios = this.comentarios.value;
            this.calificacion.nota = Number.parseFloat(this.nota.value);
            this.target.setAttribute('data-comentarios',this.calificacion.comentarios);
            this.target.setAttribute('data-nota',this.calificacion.nota);
            this.notaLabel.innerText = this.calificacion.nota;
            this.target.innerHTML = '<i class="bi bi-pencil"></i>';
        },
        reset:function(){
            this.target=null;
            this.titulo.value='';
            this.comentarios.value='';
            this.nota.value='';
            this.calificacion.usuario='';
            this.calificacion.nota=0.0;
            this.calificacion.comentarios='';
            this.notaLabel = null;
        }
    }
    let capacitacion = {};
    document.addEventListener('DOMContentLoaded',()=>{
        let dataDiv = document.querySelector('#dejack');
        capacitacion = {
            id : dataDiv.getAttribute('data-cap-id'),
            tutores : Number.parseInt(dataDiv.getAttribute('data-init-t')),
            alumnos : Number.parseInt(dataDiv.getAttribute('data-init-a')),
            maxTutores : Number.parseInt(dataDiv.getAttribute('data-max-t')),
            maxAlumnos : Number.parseInt(dataDiv.getAttribute('data-max-a'))
        };
        modal.titulo = document.getElementById('notasModalLabel');
        modal.comentarios = document.getElementById('modal-comentarios');
        modal.nota = document.getElementById('modal-nota');
        document.getElementById('btn-guardar').addEventListener('click', function(event){
            modal.calificar();
            patch('/api/v1/capacitaciones/'+capacitacion.id+'/calificar',modal.calificacion,(data)=>{
                if(data.status==200){
                    modal.reset();
                }else{
                    console.log(data.contenido.error);
                }
            });
        });
        document.querySelectorAll('.btn-eval').forEach(b=>{
            b.addEventListener('click', function(event){
                modal.setData(event.currentTarget);
            });
        });
        document.querySelectorAll('[data-bs-toggle="tooltip"]').forEach(e => new bootstrap.Tooltip(e));
    });
})();