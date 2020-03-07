package ong.desktopApp.controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
import ong.hibernate.OngDAOHibernate;
import ong.hibernate.PersonalInternacional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;


public class FXML_VIController {

    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";
    public static OngDAOHibernate componenteService;
    public static List<PersonalInternacional> listPersonalInternacional;


    // editable table view
    @FXML
    private JFXTreeTableView<FXML_VIController.PersonInt> editableTreeTableView;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, Integer> idColumn;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, String> firstNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, String> lastNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, String> streetEditableColumn;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, String> stateEditableColumn;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, String> phoneEditableColumn;
    @FXML
    private JFXTreeTableColumn<FXML_VIController.PersonInt, String> mailEditableColumn;


    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() throws IOException {
        componenteService = new OngDAOHibernate();
        listPersonalInternacional = componenteService.mostrarPersonasInternacional();
        setupEditableTableView();

    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<FXML_VIController.PersonInt, T> column, Function<FXML_VIController.PersonInt, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<FXML_VIController.PersonInt, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }


    private void setupEditableTableView() {
        setupCellValueFactory(idColumn, p -> p.id.asObject());
        setupCellValueFactory(firstNameEditableColumn, FXML_VIController.PersonInt::firstNameProperty);
        setupCellValueFactory(lastNameEditableColumn, FXML_VIController.PersonInt::lastNameProperty);
        setupCellValueFactory(streetEditableColumn, FXML_VIController.PersonInt::streetProperty);
        setupCellValueFactory(stateEditableColumn, FXML_VIController.PersonInt::stateProperty);
        setupCellValueFactory(phoneEditableColumn, FXML_VIController.PersonInt::phoneProperty);
        setupCellValueFactory(mailEditableColumn, FXML_VIController.PersonInt::mailProperty);

        PersonalInternacional internacional = new PersonalInternacional();

        // add editors
        firstNameEditableColumn.setCellFactory((TreeTableColumn<FXML_VIController.PersonInt, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        firstNameEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<FXML_VIController.PersonInt, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().firstName.set(t.getNewValue());

            internacional.setId(t.getRowValue().getValue().id.intValue());
            internacional.setNombre(t.getNewValue());
            internacional.setApellido(t.getRowValue().getValue().lastName.get());
            internacional.setDireccion(t.getRowValue().getValue().street.get());
            internacional.setPais(t.getRowValue().getValue().state.get());
            internacional.setTelefono(t.getRowValue().getValue().phone.get());
            internacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersonaInternacional(internacional);
        });

        lastNameEditableColumn.setCellFactory((TreeTableColumn<FXML_VIController.PersonInt, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        lastNameEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<FXML_VIController.PersonInt, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().lastName.set(t.getNewValue());

            internacional.setId(t.getRowValue().getValue().id.intValue());
            internacional.setNombre(t.getRowValue().getValue().firstName.get());
            internacional.setApellido(t.getNewValue());
            internacional.setDireccion(t.getRowValue().getValue().street.get());
            internacional.setPais(t.getRowValue().getValue().state.get());
            internacional.setTelefono(t.getRowValue().getValue().phone.get());
            internacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersonaInternacional(internacional);
        });


        streetEditableColumn.setCellFactory((TreeTableColumn<FXML_VIController.PersonInt, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        streetEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<FXML_VIController.PersonInt, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().street.set(t.getNewValue());

            internacional.setId(t.getRowValue().getValue().id.intValue());
            internacional.setNombre(t.getRowValue().getValue().firstName.get());
            internacional.setApellido(t.getRowValue().getValue().lastName.get());
            internacional.setDireccion(t.getNewValue());
            internacional.setPais(t.getRowValue().getValue().state.get());
            internacional.setTelefono(t.getRowValue().getValue().phone.get());
            internacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersonaInternacional(internacional);
        });

        stateEditableColumn.setCellFactory((TreeTableColumn<FXML_VIController.PersonInt, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        stateEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<FXML_VIController.PersonInt, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().state.set(t.getNewValue());

            internacional.setId(t.getRowValue().getValue().id.intValue());
            internacional.setNombre(t.getRowValue().getValue().firstName.get());
            internacional.setApellido(t.getRowValue().getValue().lastName.get());
            internacional.setDireccion(t.getRowValue().getValue().street.get());
            internacional.setPais(t.getNewValue());
            internacional.setTelefono(t.getRowValue().getValue().phone.get());
            internacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersonaInternacional(internacional);
        });

        phoneEditableColumn.setCellFactory((TreeTableColumn<FXML_VIController.PersonInt, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        phoneEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<FXML_VIController.PersonInt, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().phone.set(t.getNewValue());

            internacional.setId(t.getRowValue().getValue().id.intValue());
            internacional.setNombre(t.getRowValue().getValue().firstName.get());
            internacional.setApellido(t.getRowValue().getValue().lastName.get());
            internacional.setDireccion(t.getRowValue().getValue().street.get());
            internacional.setPais(t.getRowValue().getValue().state.get());
            internacional.setTelefono(t.getNewValue());
            internacional.setMail(t.getRowValue().getValue().mail.get());
            componenteService.actualizarPersonaInternacional(internacional);
        });

        mailEditableColumn.setCellFactory((TreeTableColumn<FXML_VIController.PersonInt, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        mailEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<FXML_VIController.PersonInt, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().mail.set(t.getNewValue());

            internacional.setId(t.getRowValue().getValue().id.intValue());
            internacional.setNombre(t.getRowValue().getValue().firstName.get());
            internacional.setApellido(t.getRowValue().getValue().lastName.get());
            internacional.setDireccion(t.getRowValue().getValue().street.get());
            internacional.setPais(t.getRowValue().getValue().state.get());
            internacional.setTelefono(t.getRowValue().getValue().phone.get());
            internacional.setMail(t.getNewValue());
            componenteService.actualizarPersonaInternacional(internacional);
        });


        final ObservableList<FXML_VIController.PersonInt> dummyData = getData(200);
        editableTreeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        editableTreeTableView.setShowRoot(false);
        editableTreeTableView.setEditable(true);


    }

    private ChangeListener<String> setupSearchField(final JFXTreeTableView<FXML_VIController.PersonInt> tableView) {
        return (o, oldVal, newVal) ->
                tableView.setPredicate(personProp -> {
                    final FXML_VIController.PersonInt person = personProp.getValue();
                    return Integer.toString(person.id.get()).contains(newVal)
                            || person.firstName.get().contains(newVal)
                            || person.lastName.get().contains(newVal)
                            || person.street.get().contains(newVal)
                            || person.state.get().contains(newVal)
                            || person.phone.get().contains(newVal)
                            || person.mail.get().contains(newVal);
                });
    }

    private ObservableList<FXML_VIController.PersonInt> getData(final int numberOfEntries) {

        final ObservableList<FXML_VIController.PersonInt> data = FXCollections.observableArrayList();

        for (PersonalInternacional persona : listPersonalInternacional) {

            data.add(
                    new FXML_VIController.PersonInt(
                            persona.getId(),
                            persona.getNombre(),
                            persona.getApellido(),
                            persona.getDireccion(),
                            persona.getPais(),
                            persona.getTelefono(),
                            persona.getMail())
            );
        }
        return data;
    }


    static final class PersonInt extends RecursiveTreeObject<FXML_VIController.PersonInt> {
        final IntegerProperty id;
        final StringProperty firstName;
        final StringProperty lastName;
        final StringProperty street;
        final StringProperty state;
        final StringProperty phone;
        final StringProperty mail;

        PersonInt(Integer id, String firstName, String lastName,
                  String street, String state,
                  String phone, String mail) {

            this.id = new SimpleIntegerProperty((id));
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.street = new SimpleStringProperty(street);
            this.state = new SimpleStringProperty(state);
            this.phone = new SimpleStringProperty(phone);
            this.mail = new SimpleStringProperty(mail);
        }


        IntegerProperty idProperty() {
            return id;
        }

        StringProperty firstNameProperty() {
            return firstName;
        }

        StringProperty lastNameProperty() {
            return lastName;
        }

        StringProperty streetProperty() {
            return street;
        }

        StringProperty stateProperty() {
            return state;
        }

        StringProperty phoneProperty() {
            return phone;
        }

        StringProperty mailProperty() {
            return mail;
        }

    }
}


