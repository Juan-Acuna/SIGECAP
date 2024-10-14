(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded', ()=>{
        const form = document.querySelector('form');
        form.onsubmit = (event)=>{
            event.preventDefault();
            let usuario = {
                nombres:form['nombres'].value,
                apellidos: form['apellidos'].value,
                email: form['email'].value,
                rol:{
                    id:form['rol'].value,
                    nombre: form['rol'].innerText
                },
                activo: true,
                pwd: form['passwor'].value,
            };
            post(form.action, usuario, (data) => {
                if(data.status==200){
                    redirect('/');
                }else{
                    alert(data.contenido.error);
                }
            });
        };
        form['fecha'].onchange = actualizarAgenda;
        form['hora'].onchange = actualizarAgenda;
        form['duracion'].onchange = actualizarAgenda;
        form['fecha'].min=form['fecha'].value;
        actualizarAgenda();
    });
})();