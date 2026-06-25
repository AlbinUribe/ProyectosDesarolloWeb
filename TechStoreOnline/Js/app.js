import { mostrarProductos } from "./productos.js";
import { agregarAlCarrito, mostrarCarrito, vaciarCarrito, inicializarPago } from "./carrito.js";
import { validarFormularioContacto } from "./validaciones.js";

document.addEventListener("DOMContentLoaded", async () => {
  // -------------------------------
  // Productos.html → renderizar catálogo
  // -------------------------------
  const contenedorProductos = document.getElementById("contenedor-productos");
  if (contenedorProductos) {
    mostrarProductos();
  }

  // -------------------------------
  // Carrito.html → mostrar carrito y activar botones
  // -------------------------------
  const contenedorCarrito = document.getElementById("contenedor-carrito");
  if (contenedorCarrito) {
    mostrarCarrito();

    const botonVaciar = document.getElementById("vaciar-carrito");
    if (botonVaciar) {
      botonVaciar.addEventListener("click", vaciarCarrito);
    }

    inicializarPago();
  }

  // -------------------------------
  // Contacto.html → validar formulario
  // -------------------------------
  const formContacto = document.getElementById("form-contacto");
  if (formContacto) {
    validarFormularioContacto();
  }

  // -------------------------------
  // Index.html → lógica de destacados y categorías
  // -------------------------------
  const respuesta = await fetch("./data/productos.json");
  const productos = await respuesta.json();

  document.querySelectorAll("main section article").forEach(article => {
    const nombre = article.querySelector("h3")?.textContent.trim();
    const producto = productos.find(p => p.nombre === nombre);

    if (producto) {
      const btnComprar = article.querySelector(".btn-comprar");
      const btnDetalle = article.querySelector(".btn-detalle");

      if (btnComprar) {
        btnComprar.addEventListener("click", () => {
          agregarAlCarrito(producto);
        });
      }

      if (btnDetalle) {
        btnDetalle.addEventListener("click", () => {
          localStorage.setItem("productoDetalle", JSON.stringify(producto));
          window.location.href = "producto.html";
        });
      }
    }
  });

  // -------------------------------
  // Lógica para categorías → redirigir con filtro
  // -------------------------------
  document.querySelectorAll("section article h2").forEach(cat => {
    cat.style.cursor = "pointer";
    cat.addEventListener("click", () => {
      const categoria = cat.textContent.trim();
      localStorage.setItem("categoriaFiltro", categoria);
      window.location.href = "productos.html";
    });
  });

  // -------------------------------
  // Botones extra en productos.html (ordenar, invertir, mostrar nombres)
  // -------------------------------
  const btnOrdenar = document.getElementById("ordenar-precio");
  if (btnOrdenar) {
    btnOrdenar.addEventListener("click", () => {
      mostrarProductos(); // delega en productos.js
    });
  }

  const btnInvertir = document.getElementById("invertir-orden");
  if (btnInvertir) {
    btnInvertir.addEventListener("click", () => {
      mostrarProductos(); // delega en productos.js
    });
  }

  const btnNombres = document.getElementById("mostrar-nombres");
  if (btnNombres) {
    btnNombres.addEventListener("click", () => {
      mostrarProductos(); // delega en productos.js
    });
  }
});

