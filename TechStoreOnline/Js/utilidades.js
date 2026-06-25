// -------------------------------
// Sistema de Favoritos
// -------------------------------
export function agregarFavorito(producto) {
  try {
    let favoritos = JSON.parse(localStorage.getItem("favoritos")) || [];
    const existe = favoritos.find(p => p.id === producto.id);

    if (!existe) {
      favoritos.push(producto);
      localStorage.setItem("favoritos", JSON.stringify(favoritos));
      mostrarMensaje("Producto agregado a favoritos", "success");
    } else {
      mostrarMensaje("Ya está en favoritos", "warning");
    }
  } catch (error) {
    mostrarMensaje("Error al agregar favorito: " + error.message, "warning");
  }
}

export function mostrarFavoritos() {
  const contenedor = document.getElementById("contenedor-favoritos");
  if (!contenedor) return;

  const favoritos = JSON.parse(localStorage.getItem("favoritos")) || [];
  contenedor.innerHTML = "";

  if (favoritos.length === 0) {
    contenedor.innerHTML = "<p>No tienes favoritos guardados.</p>";
    return;
  }

  favoritos.forEach(producto => {
    const tarjeta = document.createElement("article");
    tarjeta.innerHTML = `
      <img src="${producto.imagen}" alt="${producto.nombre}">
      <h3>${producto.nombre}</h3>
      <p>Precio: $${producto.precio}</p>
      <button class="btn-rojo">Comprar</button>
    `;
    contenedor.appendChild(tarjeta);
  });
}

// -------------------------------
// Generación de Facturas
// -------------------------------
export function generarFactura() {
  try {
    const carrito = JSON.parse(localStorage.getItem("carrito")) || [];
    if (carrito.length === 0) throw new Error("El carrito está vacío");

    let total = 0;
    let factura = `
      <h2>Factura - La Pulga Digital</h2>
      <table>
        <thead>
          <tr>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>Subtotal</th>
          </tr>
        </thead>
        <tbody>
    `;

    carrito.forEach(p => {
      const subtotal = p.precio * p.cantidad;
      total += subtotal;
      factura += `
        <tr>
          <td>${p.nombre}</td>
          <td>${p.cantidad}</td>
          <td>$${p.precio}</td>
          <td>$${subtotal.toFixed(2)}</td>
        </tr>
      `;
    });

    factura += `
        </tbody>
      </table>
      <h3>Total: $${total.toFixed(2)}</h3>
      <p>Gracias por su compra.</p>
    `;

    const contenedorFactura = document.getElementById("contenedor-factura");
    if (contenedorFactura) contenedorFactura.innerHTML = factura;

    mostrarMensaje("Factura generada correctamente", "success");
  } catch (error) {
    mostrarMensaje("Error al generar factura: " + error.message, "warning");
  } finally {
    console.log("Generación de factura finalizada");
  }
}

// -------------------------------
// Utilidad para mensajes dinámicos
// -------------------------------
export function mostrarMensaje(texto, tipo = "info") {
  const contenedor = document.getElementById("mensajes");
  if (!contenedor) return;

  const mensaje = document.createElement("div");
  mensaje.className = `mensaje ${tipo}`;
  mensaje.textContent = texto;

  contenedor.appendChild(mensaje);

  setTimeout(() => mensaje.remove(), 3000);
}
