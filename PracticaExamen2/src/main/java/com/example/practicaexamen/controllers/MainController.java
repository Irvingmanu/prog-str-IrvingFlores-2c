package com.example.practicaexamen.controllers;

import com.example.practicaexamen.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;

public class MainController {

    // Las etiquetas @FXML conectan estas variables con los elementos visuales de tu archivo XML
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private ListView<String> listView;
    @FXML private Label lblMsg;

    // Esta lista especial es la que se conecta visualmente con el ListView
    private final ObservableList<String> data = FXCollections.observableArrayList();

    // Instanciamos nuestro "cerebro" (el servicio)
    ContactService service = new ContactService();

    // REGLA 3: Arreglo de String con los parentescos permitidos.
    String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    // Método especial que JavaFX ejecuta automáticamente al abrir la ventana
    @FXML
    public void initialize() {
        // Conecta la lista visual con la lista de datos observables
        listView.setItems(data);

        // Carga el arreglo de parentescos en el menú desplegable (ComboBox)
        cmbParentesco.getItems().addAll(parentescos);

        reload(); // Carga datos iniciales (estará vacío al principio)

        // Esto es un "Escuchador": Si haces clic en un elemento de la lista en la pantalla...
        listView.getSelectionModel().selectedItemProperty().addListener((obs, o, n) -> {
            if (n != null) {
                // Separa el texto "Nombre-Telefono-Parentesco" usando el guion como separador
                String[] p = n.split("-");
                // Pone esos datos de vuelta en las cajitas de texto para que puedas verlos
                txtNombre.setText(p[0]);
                txtTelefono.setText(p[1]);
                cmbParentesco.setValue(p[2]);
            }
        });
    }

    // BOTÓN AGREGAR
    @FXML
    public void onAdd() {
        try {
            // Le manda los datos escritos al servicio para que los guarde
            service.addContact(txtNombre.getText(), txtTelefono.getText(), cmbParentesco.getValue());
            reload(); // Refresca la lista en pantalla
            clear();  // Limpia las cajitas
            lblMsg.setText("Agregado con éxito"); // Opcional: mensaje de éxito
        } catch (Exception e) {
            // Si el servicio lanza un error (ej. faltan datos), lo muestra en la etiqueta (Label)
            lblMsg.setText(e.getMessage());
        }
    }

    // BOTÓN ACTUALIZAR
    @FXML
    public void onUpdate() {
        try {
            // Leemos los datos directamente de las cajas de texto en la pantalla
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String parentesco = cmbParentesco.getValue();

            // Se los mandamos al servicio
            service.updateContact(nombre, telefono, parentesco);

            // Si todo sale bien, refrescamos y limpiamos
            reload();
            clear();
            lblMsg.setText("Contacto actualizado con éxito");

        } catch (Exception e) {
            // Si hay un error (ej. no se encontró el nombre), lo mostramos
            lblMsg.setText(e.getMessage());
        }
    }

    // BOTÓN ELIMINAR
    @FXML
    public void onDelete() {
        try {
            // Tomamos el nombre escrito en la caja de texto
            String nombre = txtNombre.getText();

            // Verificamos rápido que no hayan presionado el botón con la caja vacía
            if (nombre.isBlank()) {
                lblMsg.setText("Escribe el nombre del contacto a eliminar");
                return; // Detenemos la ejecución aquí
            }

            // Mandamos el nombre al servicio para que lo borre
            service.deleteContact(nombre);

            // Refrescamos y limpiamos
            reload();
            clear();
            lblMsg.setText("Contacto eliminado con éxito");

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }
    // BOTÓN BUSCAR
    @FXML
    public void onSearch() {
        String nombre = txtNombre.getText();
        // Busca en el servicio
        var c = service.search(nombre);

        if (c != null) {
            // Si lo encuentra, rellena los campos en la pantalla con los datos encontrados
            txtTelefono.setText(c.getTelefono());
            cmbParentesco.setValue(c.getParentesco());
            lblMsg.setText("Contacto encontrado");
        } else {
            lblMsg.setText("No encontrado");
        }
    }

    // BOTÓN LIMPIAR
    @FXML
    public void onClear() {
        clear();
    }

    // Método auxiliar para refrescar el ListView pidiéndole los datos actualizados al servicio
    private void reload() {
        List<String> items = service.loadForListView();
        data.setAll(items);
    }

    // Método auxiliar para borrar el texto de las cajas en pantalla
    private void clear() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
        lblMsg.setText(""); // Limpia también el mensaje de error/éxito
    }
}