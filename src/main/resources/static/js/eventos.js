document.addEventListener('DOMContentLoaded', function () {
    const numberField = document.getElementById('numberEvento');
    const personasCount = document.getElementById('personasCount');
    const rangeInput = document.getElementById('numberEvento');
    const form = document.getElementById('eventosConsulta');
    const successModal = new bootstrap.Modal(document.getElementById('successModal'));
    const phoneField = document.getElementById('telEvento');
    const showEventsBtn = document.getElementById('showEventsBtn');
    const eventsContainer = document.getElementById('eventsContainer');

    // Verificar si los elementos existen antes de usarlos
    if (numberField && personasCount && rangeInput) {
        numberField.addEventListener('input', function () {
            personasCount.textContent = numberField.value;
        });

        rangeInput.addEventListener('input', function () {
            personasCount.textContent = rangeInput.value;
        });
    }



    // Configuración de Flatpickr para selector de fecha y hora
    flatpickr("#dateEvento", {
        dateFormat: "Y-m-d",
        allowInput: true,
        minDate: "today",
        maxDate: new Date().fp_incr(60),
        locale: { firstDayOfWeek: 1 }
    });

    flatpickr("#timeEvento", {
        enableTime: true,
        noCalendar: true,
        dateFormat: "H:i",
        allowInput: true,
        time_24hr: true,
        minTime: "12:00"
    });

    // Validación y envío de formulario
    if (form) {
        form.addEventListener('submit', function (event) {
            event.preventDefault(); // Evitar el envío automático del formulario
            const invalidFeedbacks = form.querySelectorAll('.invalid-feedback');

            invalidFeedbacks.forEach(feedback => feedback.style.display = 'none'); // Ocultar feedbacks anteriores

            let isValid = form.checkValidity();

            // Validación adicional para el campo de teléfono
            if (phoneField) {
                const phoneValue = phoneField.value.trim();
                if (phoneValue.length < 9 || isNaN(phoneValue)) {
                    phoneField.classList.add('is-invalid');
                    phoneField.nextElementSibling.style.display = 'block';
                    setTimeout(() => phoneField.nextElementSibling.style.display = 'none', 5000);
                    isValid = false;
                }
            }

            if (isValid) {
                // Enviar datos al backend
                fetch(form.action, {
                    method: form.method,
                    body: new FormData(form)
                })
                    .then(response => {
                        if (response.ok) {
                            successModal.show(); // Mostrar modal de éxito
                            form.reset(); // Limpiar formulario
                            personasCount.textContent = 20; // Resetear el contador de personas
                        } else {
                            alert("Error al enviar el formulario. Inténtalo de nuevo.");
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert("Hubo un problema al enviar el formulario.");
                    });
            } else {
                form.classList.add('was-validated');
            }
        });
    }

    // Agregar clase a campos completados
    const fields = document.querySelectorAll('.form-control, .form-range');
    fields.forEach(field => {
        field.addEventListener('input', () => {
            if (field.checkValidity()) {
                field.classList.add('completed-field');
            } else {
                field.classList.remove('completed-field');
            }
        });
    });
});
