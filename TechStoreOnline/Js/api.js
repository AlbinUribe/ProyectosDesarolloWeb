export async function cargarProductosExternos() {
  try {
    const respuesta = await fetch("https://fakestoreapi.com/products");
    if (!respuesta.ok) {
      throw new Error("No se pudo conectar con la API");
    }
    const datos = await respuesta.json();
    return datos;
  } catch (error) {
    mostrarMensaje("Error al cargar productos externos: " + error.message, "warning");
    return [];
  } finally {
    console.log("Intento de carga de API finalizado");
  }
}
