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
                activo: form['estado'].checked,
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
    });
})();