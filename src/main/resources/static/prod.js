const options = {
    method: 'GET',
    headers: {
      accept: 'application/json',
      Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTJjYTAwZDYxZWIzOTEyYjZlNzc4MDA4YWQ3ZmNjOCIsInN1YiI6IjYyODJmNmYwMTQ5NTY1MDA2NmI1NjlhYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4MJSPDJhhpbHHJyNYBtH_uCZh4o0e3xGhZpcBIDy-Y8'
    }
  };
  

  function getProductos() {
//    const respuesta = fetch(`https://api.themoviedb.org/3/movie/top_rated`, options);
    const respuesta = fetch(`http://localhost:8080/listarProductos`);

    //2 invocar
    respuesta
        .then(response => response.json())
        .then(response => renderProd(response))//fulfilled
        .catch(error => dibujarError(error))//rejected
  }

  function renderProd(response) {
    const productos = response;
    let rows = '';
    for(let prod of productos) {
        rows += `
        <tr>
            <td>${prod.id}</td>
            <td>${prod.nombre}</td>
            <td>${prod.descripcion}</td>
            <td>
              <img src="${prod.imagen}" alt="" class="img-fluid">
            </td>            
            <td>${prod.precio}</td>
            <td>
              <button>
                <i class="bi bi-trash-fill" onclick="del(${prod.id})"></i>
              </button>  
            </td>
        </tr>
        `
    }
    // document.getElementById("peliculas").innerHTML = rows;
    document.querySelector('#producto').innerHTML = rows;
}

function del(id) {
  //    const respuesta = fetch(`https://api.themoviedb.org/3/movie/top_rated`, options);
      const respuesta = fetch(`http://localhost:8080/delProducto/${id}`, {
        method: 'DELETE',
      });
  
      //2 invocar
      respuesta
          .then(response => okDel(response))//fulfilled
          .catch(error => dibujarError(error))//rejected
    }

function okDel(response) {
  document.querySelector('#producto').innerHTML = "Se eliminó exitosamente";
}

function dibujarError(error) {
  document.querySelector('#pelicula').innerHTML = error;
}