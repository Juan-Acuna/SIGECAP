(()=>{
    "use strict";
    document.addEventListener('DOMContentLoaded',function(){
        let botonesEliminar = document.querySelectorAll(".btnEliminar");
        botonesEliminar.forEach(b=>{
            b.onclick = (event)=>{
                event.preventDefault();
                del(event.currentTarget.getAttribute('data-url'), (data) => {
                    if(data.status==200){
                        reload();
                    }else{
                        alert(data.contenido.error);
                    }
                });
            }
        });
    });
})();