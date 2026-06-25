export function mostrarDetallesProducto() {
  const contenedor = document.getElementById("detalles-producto");
  if (!contenedor) {
    console.error("No se encontró contenedor-detalles");
    return;
  }

  


  const productoGuardado = localStorage.getItem("productoDetalle");
  if (!productoGuardado) {
    contenedor.innerHTML = "<p>No se seleccionó ningún producto.</p>";
    return;
  }

  const producto = JSON.parse(productoGuardado);

  // Renderizar información básica
  let html = `
    <h2>${producto.nombre}</h2>
    <img src="${producto.imagen}" alt="${producto.nombre}">
    <p>Precio: <strong>$${producto.precio}</strong></p>
    <p>Ahorro: <strong>${producto.descuento}%</strong></p>
  `;


  if (producto.detalles) {
    html += `
      <h3>Especificaciones</h3>
      <table>
        <thead>
          <tr><th>Característica</th><th>Valor</th></tr>
        </thead>
        <tbody>
    `;

    for (const [caracteristica, valor] of Object.entries(producto.detalles)) {
      html += `<tr><td>${caracteristica}</td><td>${valor}</td></tr>`;
    }

    html += `
        </tbody>
      </table>
    `;
  } else {
    html += "<p>No hay detalles disponibles para este producto.</p>";
  }

  contenedor.innerHTML = html;
}
