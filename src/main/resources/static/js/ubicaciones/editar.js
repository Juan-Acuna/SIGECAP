(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded', ()=>{
        const idUbi =Number.parseInt( document.getElementById('dejack').getAttribute('data-ubi-id'));
        form.onsubmit = (event)=>{
            event.preventDefault();
            let ubicacion = {
                id:idUbi,
                nombre:form['nombre'].value,
            };
            patch(form.action, ubicacion, (data) => {
                if(data.status==200){
                    alert("Se actualizo la ubicacion");
                    reload();
                }else{
                    alert(data.contenido.error);
                }
            });
        };
    });
})();