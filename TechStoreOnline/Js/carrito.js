// Utilidad para mostrar mensajes dinámicos
function mostrarMensaje(texto, tipo = "info") {
  const contenedor = document.getElementById("mensajes");
  if (!contenedor) return;

  const mensaje = document.createElement("div");
  mensaje.className = `mensaje ${tipo}`;
  mensaje.textContent = texto;

  contenedor.appendChild(mensaje);

  // Desaparece automáticamente después de 3 segundos
  setTimeout(() => {
    mensaje.remove();
  }, 3000);
}

export function agregarAlCarrito(producto) {
  try {
    if (!producto || !producto.id) {
      throw new Error("Producto inválido");
    }

    let carrito = JSON.parse(localStorage.getItem("carrito")) || [];
    const existente = carrito.find(p => p.id === producto.id);

    if (existente) {
      existente.cantidad += 1;
    } else {
      carrito.push({ ...producto, cantidad: 1 });
    }

    localStorage.setItem("carrito", JSON.stringify(carrito));
    mostrarCarrito();
    mostrarMensaje("Producto agregado al carrito", "success");
  } catch (error) {
    mostrarMensaje("Error al agregar producto: " + error.message, "warning");
  } finally {
    console.log("Operación de agregar producto finalizada");
  }
}

export function mostrarCarrito() {
  try {
    const contenedor = document.getElementById("contenedor-carrito");
    if (!contenedor) return;

    const carrito = JSON.parse(localStorage.getItem("carrito")) || [];
    contenedor.innerHTML = "";

    if (carrito.length === 0) {
      contenedor.innerHTML = "<p>El carrito está vacío.</p>";
      actualizarDescuento(0, 0);
      return;
    }

    let totalSinDescuento = 0;
    let totalConDescuento = 0;

    let tabla = `
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

    carrito.forEach(producto => {
      const subtotal = producto.precio * producto.cantidad;
      const descuento = producto.descuento || 0;
      const subtotalConDescuento = subtotal - (subtotal * descuento / 100);

      totalSinDescuento += subtotal;
      totalConDescuento += subtotalConDescuento;

      tabla += `
        <tr>
          <td>${producto.nombre}</td>
          <td>${producto.cantidad}</td>
          <td>$${producto.precio}</td>
          <td>$${subtotalConDescuento.toFixed(2)} (${descuento}% off)</td>
        </tr>
      `;
    });

    tabla += `
        </tbody>
      </table>
      <h2>Total: $${totalConDescuento.toFixed(2)}</h2>
    `;

    contenedor.innerHTML = tabla;

    const ahorro = totalSinDescuento - totalConDescuento;
    const porcentajeAhorro = totalSinDescuento > 0 ? (ahorro / totalSinDescuento) * 100 : 0;
    actualizarDescuento(ahorro, porcentajeAhorro);
  } catch (error) {
    mostrarMensaje("Error al mostrar carrito: " + error.message, "warning");
  } finally {
    console.log("Renderizado del carrito finalizado");
  }
}

export function vaciarCarrito() {
  try {
    localStorage.removeItem("carrito");
    mostrarCarrito();
    mostrarMensaje("Carrito vaciado", "warning");
  } catch (error) {
    mostrarMensaje("Error al vaciar carrito: " + error.message, "warning");
  } finally {
    console.log("Operación de vaciar carrito finalizada");
  }
}

export function inicializarPago() {
  const botonPago = document.getElementById("realizar-pago");
  const mensajePago = document.getElementById("mensaje-pago");

  if (botonPago) {
    botonPago.addEventListener("click", () => {
      try {
        const metodo = document.getElementById("metodo-pago").value;
        if (!metodo) throw new Error("Método de pago no seleccionado");

        mensajePago.textContent = `Pago realizado con ${metodo}. ¡Gracias por tu compra!`;

        localStorage.removeItem("carrito");
        mostrarCarrito();
        mostrarMensaje("Pago completado con éxito", "success");
      } catch (error) {
        mostrarMensaje("Error en el pago: " + error.message, "warning");
      } finally {
        console.log("Operación de pago finalizada");
      }
    });
  }
}

// Actualizar barra de descuento
function actualizarDescuento(ahorro, porcentaje) {
  const barra = document.querySelector("meter");
  const textoAhorro = barra?.nextElementSibling;

  if (barra) barra.value = porcentaje;
  if (textoAhorro) textoAhorro.textContent = `Has ahorrado $${ahorro.toFixed(2)} (${porcentaje.toFixed(1)}%)`;
}


