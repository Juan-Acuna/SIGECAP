(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded', ()=>{
        const idRol =Number.parseInt( document.getElementById('dejack').getAttribute('data-rol-id'));
        form.onsubmit = (event)=>{
            event.preventDefault();
            let rol = {
                id: idRol,
                nombre:form['nombre'].value,
            };
            patch(form.action, rol, (data) => {
                if(data.status==200){
                    alert("Se actualizo el rol");
                    reload();
                }else{
                    alert(data.contenido.error);
                }
            });
        };
    });
})();