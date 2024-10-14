(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded', ()=>{
        const form = document.querySelector('form');
        form.onsubmit = (event)=>{
            event.preventDefault();
            let ubicacion = {
                nombre:form['nombre'].value,
            };
            post(form.action, ubicacion, (data) => {
                if(data.status==200){
                    redirect('/');
                }else{
                    alert(data.contenido.error);
                }
            });
        };
    });
})();