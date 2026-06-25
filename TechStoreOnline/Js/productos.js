import { agregarAlCarrito } from "./carrito.js";

let productosGlobal = [];

export async function mostrarProductos() {
  const contenedor = document.getElementById("contenedor-productos");
  if (!contenedor) {
    console.error("No se encontró contenedor-productos");
    return;
  }

  try {
    const respuesta = await fetch("./data/productos.json");
    productosGlobal = await respuesta.json();

    // Revisar si hay filtro por categoría desde index
    const categoriaFiltro = localStorage.getItem("categoriaFiltro");
    if (categoriaFiltro) {
      const filtrados = productosGlobal.filter(p => p.categoria === categoriaFiltro);
      renderizarProductos(filtrados);
      localStorage.removeItem("categoriaFiltro");
    } else {
      renderizarProductos(productosGlobal);
    }

    // Activar filtros
    const formFiltros = document.getElementById("form-filtros");
    if (formFiltros) {
      formFiltros.addEventListener("submit", e => {
        e.preventDefault();
        aplicarFiltros();
      });
    }

    // Botones extra para ordenar, invertir y mostrar nombres
    const btnOrdenar = document.getElementById("ordenar-precio");
    if (btnOrdenar) btnOrdenar.addEventListener("click", ordenarPorPrecio);

    const btnInvertir = document.getElementById("invertir-orden");
    if (btnInvertir) btnInvertir.addEventListener("click", invertirOrden);

    const btnNombres = document.getElementById("mostrar-nombres");
    if (btnNombres) btnNombres.addEventListener("click", mostrarNombres);
  } catch (error) {
    console.error("Error:", error);
  }
}

function renderizarProductos(productos) {
  const contenedor = document.getElementById("contenedor-productos");
  contenedor.innerHTML = "";

  productos.forEach((producto, indice) => {
    const tarjeta = document.createElement("article");
    tarjeta.innerHTML = `
      <img src="${producto.imagen}" alt="${producto.nombre}">
      <h3>${producto.nombre}</h3>
      <p>Precio: <strong>$${producto.precio}</strong></p>
      <p>Ahorro: <strong>${producto.descuento}%</strong></p>
      <button class="btn-rojo">Comprar</button>
      <button class="btn-detalle">Ver detalles</button>
      <button class="btn-eliminar">Eliminar</button>
    `;

    // Botón comprar
    tarjeta.querySelector(".btn-rojo").addEventListener("click", () => {
      agregarAlCarrito(producto);
    });

    // Botón ver detalles
    tarjeta.querySelector(".btn-detalle").addEventListener("click", () => {
      localStorage.setItem("productoDetalle", JSON.stringify(producto));
      window.location.href = "producto.html";
    });

    // Botón eliminar usando splice
    tarjeta.querySelector(".btn-eliminar").addEventListener("click", () => {
      productosGlobal.splice(indice, 1); // elimina producto del array
      renderizarProductos(productosGlobal);
    });

    contenedor.appendChild(tarjeta);
  });
}

function aplicarFiltros() {
  const precioMax = parseFloat(document.getElementById("precio").value) || Infinity;
  const marca = document.getElementById("marca").value;
  const categoria = document.getElementById("categoria").value;
  const descuentoMin = parseFloat(document.getElementById("descuento").value) || 0;

  const filtrados = productosGlobal.filter(p => {
    const cumplePrecio = p.precio <= precioMax;
    const cumpleMarca = marca ? p.marca === marca : true;
    const cumpleCategoria = categoria ? p.categoria === categoria : true;
    const cumpleDescuento = p.descuento >= descuentoMin;
    return cumplePrecio && cumpleMarca && cumpleCategoria && cumpleDescuento;
  });

  renderizarProductos(filtrados);
}

// Ordenar productos por precio
function ordenarPorPrecio() {
  productosGlobal.sort((a, b) => a.precio - b.precio);
  renderizarProductos(productosGlobal);
}

// Invertir orden de productos
function invertirOrden() {
  productosGlobal.reverse();
  renderizarProductos(productosGlobal);
}

// Mostrar nombres con map
function mostrarNombres() {
  const nombres = productosGlobal.map(p => p.nombre);
  alert("Productos disponibles: " + nombres.join(", "));
}


import { cargarProductosExternos } from "./api.js";

async function cargarExternos() {
  const externos = await cargarProductosExternos();
  if (externos.length > 0) {
    renderizarProductos(externos.map(p => ({
      id: p.id,
      nombre: p.title,
      precio: p.price,
      descuento: 10, // ejemplo fijo
      categoria: p.category,
      marca: "API",
      imagen: p.image
    })));
  } else {
    alert("No se pudieron cargar productos externos.");
  }
}

const btnExternos = document.getElementById("btn-externos");
if (btnExternos) {
  btnExternos.addEventListener("click", cargarExternos);
}

const btnLocales = document.getElementById("btn-locales");
if (btnLocales) {
  btnLocales.addEventListener("click", () => {
    renderizarProductos(productosGlobal); // vuelve a mostrar los locales
  });
}
