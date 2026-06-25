export function validarFormularioContacto() {
  const form = document.getElementById("form-contacto");
  if (!form) return;

  form.addEventListener("submit", e => {
    e.preventDefault();

    try {
      const nombre = document.getElementById("nombre").value.trim();
      const email = document.getElementById("email").value.trim();
      const telefono = document.getElementById("telefono").value.trim();
      const mensaje = document.getElementById("mensaje").value.trim();
      const password = document.getElementById("password")?.value.trim();

      let errores = [];

      // Validar nombre
      if (!nombre) errores.push("El nombre es obligatorio.");

      // Validar email con regex
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailRegex.test(email)) errores.push("El correo electrónico no es válido.");

      // Validar teléfono
      const telefonoRegex = /^[0-9]{8,}$/;
      if (!telefonoRegex.test(telefono)) errores.push("El teléfono debe tener al menos 8 dígitos numéricos.");

      // Validar mensaje
      if (!mensaje) errores.push("El mensaje es obligatorio.");

      // Validar contraseña
      if (password && password.length < 6) errores.push("La contraseña debe tener al menos 6 caracteres.");

      if (errores.length > 0) {
        throw new Error(errores.join(" | ")); // Lanzamos error con todos los mensajes
      }

      mostrarMensaje("Formulario enviado correctamente", "success");
      form.reset();
    } catch (error) {
      // Dividimos los errores si vienen concatenados
      const listaErrores = error.message.split(" | ");
      mostrarErrores(listaErrores);
    } finally {
      console.log("Validación del formulario finalizada");
    }
  });
}

function mostrarErrores(errores) {
  errores.forEach(err => mostrarMensaje(err, "warning"));
}

function mostrarMensaje(texto, tipo = "info") {
  const contenedor = document.getElementById("mensajes");
  if (!contenedor) return;

  const mensaje = document.createElement("div");
  mensaje.className = `mensaje ${tipo}`;
  mensaje.textContent = texto;

  contenedor.appendChild(mensaje);

  setTimeout(() => mensaje.remove(), 3000);
}
