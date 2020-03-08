package ong.desktopApp.controller;

import com.jfoenix.controls.*;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import ong.hibernate.OngDAOHibernate;
import ong.hibernate.personalNacional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class FXML_VNController {

    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";
    public static OngDAOHibernate componenteService;
    public static List<personalNacional> listPersonalNacional;

    // editable table view
    @FXML
    private JFXTreeTableView<Person> editableTreeTableView;
    @FXML
    private JFXTreeTableColumn<Person, Integer> idColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> firstNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> lastNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> familyNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> streetEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> streetNumberEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> stateEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> phoneEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> mailEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> numHoursEditableColumn;


    @FXML
    private Label treeTableViewCount;
    @FXML
    private JFXButton editabletreeTableViewAdd;
    @FXML
    private JFXButton editabletreeTableViewRemove;
    @FXML
    private Label editableTreeTableViewCount;
    @FXML
    private JFXTextField searchField;


    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() throws IOException {
        componenteService = new OngDAOHibernate();
        listPersonalNacional = componenteService.mostrarPersonas();
        setupEditableTableView();

    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<Person, T> column, Function<Person, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private void setupEditableTableView() {
        setupCellValueFactory(idColumn, p -> p.id.asObject());
        setupCellValueFactory(firstNameEditableColumn, Person::firstNameProperty);
        setupCellValueFactory(lastNameEditableColumn, Person::lastNameProperty);
        setupCellValueFactory(familyNameEditableColumn, Person::familyNameProperty);
        setupCellValueFactory(streetEditableColumn, Person::streetProperty);
        setupCellValueFactory(streetNumberEditableColumn, Person::streetNumberProperty);
        setupCellValueFactory(stateEditableColumn, Person::stateProperty);
        setupCellValueFactory(phoneEditableColumn, Person::phoneProperty);
        setupCellValueFactory(mailEditableColumn, Person::mailProperty);

        personalNacional nacional=new personalNacional();

        // add editors
        firstNameEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        firstNameEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().firstName.set(t.getNewValue());

            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getNewValue());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);

        });
        lastNameEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        lastNameEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().lastName.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getNewValue());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);
        });

        familyNameEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        familyNameEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().familyName.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getNewValue());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);
        });

        streetEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        streetEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().street.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getNewValue());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);
        });

        streetNumberEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        streetNumberEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().streetNumber.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getNewValue());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);
        });

        stateEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        stateEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().state.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getNewValue());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);
        });

        phoneEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        phoneEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().phone.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getNewValue());
            nacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersona(nacional);
        });

        mailEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        mailEditableColumn.setOnEditCommit((CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().mail.set(t.getNewValue());
            nacional.setId(t.getRowValue().getValue().id.intValue());
            nacional.setNombre(t.getRowValue().getValue().firstName.get());
            nacional.setApellido1(t.getRowValue().getValue().lastName.get());
            nacional.setApellido2(t.getRowValue().getValue().familyName.get());
            nacional.setDireccionCalle(t.getRowValue().getValue().street.get());
            nacional.setDireccionNumero(t.getRowValue().getValue().streetNumber.get());
            nacional.setProvincia(t.getRowValue().getValue().state.get());
            nacional.setTelefono(t.getRowValue().getValue().phone.get());
            nacional.setMail(t.getNewValue());
            componenteService.actualizarPersona(nacional);
        });

        final ObservableList<Person> dummyData = getData();

        editableTreeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        editableTreeTableView.setShowRoot(false);
        editableTreeTableView.setEditable(true);
        //Add Button
        editabletreeTableViewAdd.setOnMouseClicked((e) -> {
            componenteService.agregarPersona(new personalNacional());
            dummyData.add(new Person(componenteService.getLastId("personalNacional")));
            final IntegerProperty currCountProp = editableTreeTableView.currentItemsCountProperty();
            currCountProp.set(currCountProp.get() + 1);
        });
        //Del button
        editabletreeTableViewRemove.setOnMouseClicked((e) -> {
            int id = editableTreeTableView.getSelectionModel().selectedItemProperty().get().getValue().id.intValue();
            componenteService.eliminarPersona(id);
            dummyData.remove(editableTreeTableView.getSelectionModel().selectedItemProperty().get().getValue());
            final IntegerProperty currCountProp = editableTreeTableView.currentItemsCountProperty();
            currCountProp.set(currCountProp.get() - 1);
        });
        editableTreeTableViewCount.textProperty()
                .bind(Bindings.createStringBinding(() -> PREFIX + editableTreeTableView.getCurrentItemsCount() + POSTFIX,
                        editableTreeTableView.currentItemsCountProperty()));
        searchField.textProperty()
                .addListener(setupSearchField(editableTreeTableView));

    }

    private ChangeListener<String> setupSearchField(final JFXTreeTableView<FXML_VNController.Person> tableView) {
        return (o, oldVal, newVal) ->
                tableView.setPredicate(personProp -> {
                    final Person person = personProp.getValue();
                    return Integer.toString(person.id.get()).contains(newVal)
                            || person.firstName.get().contains(newVal)
                            || person.lastName.get().contains(newVal)
                            || person.familyName.get().contains(newVal)
                            || person.street.get().contains(newVal)
                            || person.streetNumber.get().contains(newVal)
                            || person.state.get().contains(newVal)
                            || person.phone.get().contains(newVal)
                            || person.mail.get().contains(newVal);
                });
    }

    private ObservableList<Person> getData() {

        final ObservableList<FXML_VNController.Person> data = FXCollections.observableArrayList();

        for(personalNacional persona: listPersonalNacional){

           data.add(
                   new FXML_VNController.Person(
                           persona.getId(),
                           persona.getNombre(),
                           persona.getApellido1(),
                           persona.getApellido2(),
                           persona.getDireccionCalle(),
                           persona.getDireccionNumero(),
                           persona.getProvincia(),
                           persona.getTelefono(),
                           persona.getMail())
           );

        }

//        DAOFactory objetoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
//        IOngDAO ongDAO = objetoFactory.getOngDAO();
//        ONG ong = ongDAO.readOngDAO();
//
//        for (Personal object: ong.lequipo) {
//            if(!(object instanceof PerVolInternacional)) {
//                data.add(
//                        new FXML_VNController.Person(
//                                object.getId(),
//                                object.getNombre(),
//                                object.getPrimerApellido(),
//                                object.getSegundoApellido(),
//                                object.getDireccion().getTipoVia() + " " + object.getDireccion().getNombreVia(),
//                                object.getDireccion().getNumero(),
//                                object.getDireccion().getProvincia().toString(),
//                                object.getTelefono(),
//                                object.getMail())
//                );
//            }
//        }
        return data;
    }

    /*
     * data class
     */
    static final class Person extends RecursiveTreeObject<Person> {
        final IntegerProperty id;
        final StringProperty firstName;
        final StringProperty lastName;
        final StringProperty familyName;
        final StringProperty street;
        final StringProperty streetNumber;
        final StringProperty state;
        final StringProperty phone;
        final StringProperty mail;

        Person(Integer id, String firstName, String lastName,
               String familyName, String street,
               String streetNumber, String state,
               String phone, String mail) {

            this.id = new SimpleIntegerProperty((id));
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.familyName = new SimpleStringProperty(familyName);
            this.street = new SimpleStringProperty(street);
            this.streetNumber = new SimpleStringProperty(streetNumber);
            this.state = new SimpleStringProperty(state);
            this.phone = new SimpleStringProperty(phone);
            this.mail = new SimpleStringProperty(mail);
        }

        public Person(int id){
            this.id = new SimpleIntegerProperty((id));
            this.firstName = new SimpleStringProperty("\"NOMBRE\"");
            this.lastName = new SimpleStringProperty("\"#1 APELLIDO\"");
            this.familyName = new SimpleStringProperty("\"#2 APELLIDO\"");
            this.street = new SimpleStringProperty("\"DIRECCION\"");
            this.streetNumber = new SimpleStringProperty("\"#\"");
            this.state = new SimpleStringProperty("\"PROVINCIA\"");
            this.phone = new SimpleStringProperty("\"TELEFONO\"");
            this.mail = new SimpleStringProperty("\"CORREO\"");
        }

        IntegerProperty idProperty() { return id; }
        StringProperty firstNameProperty() { return firstName; }
        StringProperty lastNameProperty() { return lastName; }
        StringProperty familyNameProperty() { return familyName; }
        StringProperty streetProperty() { return street; }
        StringProperty streetNumberProperty() { return streetNumber; }
        StringProperty stateProperty() { return state; }
        StringProperty phoneProperty() { return phone; }
        StringProperty mailProperty() { return mail; }

    }
}
