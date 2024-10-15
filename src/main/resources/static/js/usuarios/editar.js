(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded', ()=>{
        const idUsu =Number.parseInt( document.getElementById('dejack').getAttribute('data-usu-id'));
        const form = document.querySelector('form');
        form.onsubmit = (event)=>{
            event.preventDefault();
            let usuario = {
                id:idUsu,
                nombres:form['nombres'].value,
                apellidos: form['apellidos'].value,
                email: form['email'].value,
                rol:{
                    id:form['rol'].value,
                    nombre: form['rol'].innerText
                },
                activo: form['estado'].checked,
            };
            if(form['pwd'].value!=''){
                usuario.pwd = form['pwd'].value;
            }
            patch(form.action, usuario, (data) => {
                if(data.status==200){
                    alert("Se actualizo el usuario");
                    reload();
                }else{
                    alert(data.contenido.error);
                }
            });
        };
    });
})();