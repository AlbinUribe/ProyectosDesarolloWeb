export async function inicializarBuscador() {
  const form = document.getElementById("form-busqueda");
  const input = document.getElementById("input-busqueda");
  const sugerencias = document.getElementById("sugerencias");

  if (!form || !input || !sugerencias) return;

  // Cargar productos desde JSON
  let productos = [];
  try {
    const respuesta = await fetch("./data/productos.json");
    productos = await respuesta.json();
  } catch (error) {
    console.error("Error cargando productos:", error);
    return;
  }

  // Búsqueda directa al enviar formulario
  form.addEventListener("submit", e => {
    e.preventDefault();
    const query = input.value.trim().toLowerCase();

    const producto = productos.find(p => p.nombre.toLowerCase() === query);
    if (producto) {
      localStorage.setItem("productoDetalle", JSON.stringify(producto));
      window.location.href = "producto.html";
    } else {
      alert("No se encontró el producto exacto. Prueba con otra búsqueda.");
    }
  });

  // Sugerencias dinámicas mientras escribes
  input.addEventListener("input", () => {
    const query = input.value.trim().toLowerCase();
    sugerencias.innerHTML = "";

    if (query.length < 2) return;

    const coincidencias = productos.filter(p =>
      p.nombre.toLowerCase().includes(query) ||
      p.categoria.toLowerCase().includes(query) ||
      p.marca.toLowerCase().includes(query)
    );

    coincidencias.forEach(p => {
      const item = document.createElement("div");
      item.classList.add("sugerencia-item");
      item.innerHTML = `
        <img src="${p.imagen}" alt="${p.nombre}" style="width:40px;height:auto;margin-right:8px;vertical-align:middle;">
        <span>${p.nombre} - $${p.precio}</span>
      `;
      item.addEventListener("click", () => {
        localStorage.setItem("productoDetalle", JSON.stringify(p));
        window.location.href = "producto.html";
      });
      sugerencias.appendChild(item);
    });
  });
}
