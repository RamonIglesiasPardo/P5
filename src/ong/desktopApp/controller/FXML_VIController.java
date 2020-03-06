package ong.desktopApp.controller;

import com.jfoenix.controls.*;
        import com.jfoenix.controls.cells.editors.IntegerTextFieldEditorBuilder;
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
import ong.dao.DAOFactory;
import ong.dao.IOngDAO;
import ong.entreculturas.Main;
import ong.entreculturas.MenusConsola;
import ong.entreculturas.ONG;
import ong.entreculturas.Personal;

import javax.annotation.PostConstruct;
        import java.security.SecureRandom;
        import java.util.Random;
        import java.util.function.Function;

public class FXML_VIController {

    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";

    // readonly table view
    @FXML
    private JFXTreeTableView<Person> treeTableView;
    @FXML
    private JFXTreeTableColumn<Person, String> firstNameColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> lastNameColumn;
    @FXML
    private JFXTreeTableColumn<Person, Integer> ageColumn;
    @FXML
    private JFXTextField searchField;

    // editable table view
    @FXML
    private JFXTreeTableView<Person> editableTreeTableView;
    @FXML
    private JFXTreeTableColumn<Person, String> firstNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> lastNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, Integer> ageEditableColumn;
    @FXML
    private Label treeTableViewCount;
    @FXML
    private JFXButton treeTableViewAdd;
    @FXML
    private JFXButton treeTableViewRemove;
    @FXML
    private Label editableTreeTableViewCount;
    @FXML
    private JFXTextField searchField2;

    private final String[] names = {"Morley", "Scott", "Kruger", "Lain",
            "Kennedy", "Gawron", "Han", "Hall", "Aydogdu", "Grace",
            "Spiers", "Perera", "Smith", "Connoly",
            "Sokolowski", "Chaow", "James", "June",};
    private final Random random = new SecureRandom();

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {
        setupReadOnlyTableView();
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

    private void setupReadOnlyTableView() {
        setupCellValueFactory(firstNameColumn, Person::firstNameProperty);
        setupCellValueFactory(lastNameColumn, Person::lastNameProperty);
        setupCellValueFactory(ageColumn, p -> p.age.asObject());

        ObservableList<Person> dummyData = generateDummyData(100);

        treeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));

        treeTableView.setShowRoot(false);
        treeTableViewCount.textProperty()
                .bind(Bindings.createStringBinding(() -> PREFIX + treeTableView.getCurrentItemsCount() + POSTFIX,
                        treeTableView.currentItemsCountProperty()));
        treeTableViewAdd.disableProperty()
                .bind(Bindings.notEqual(-1, treeTableView.getSelectionModel().selectedIndexProperty()));
        treeTableViewRemove.disableProperty()
                .bind(Bindings.equal(-1, treeTableView.getSelectionModel().selectedIndexProperty()));
        treeTableViewAdd.setOnMouseClicked((e) -> {
            dummyData.add(createNewRandomPerson());
            final IntegerProperty currCountProp = treeTableView.currentItemsCountProperty();
            currCountProp.set(currCountProp.get() + 1);
        });
        treeTableViewRemove.setOnMouseClicked((e) -> {
            dummyData.remove(treeTableView.getSelectionModel().selectedItemProperty().get().getValue());
            final IntegerProperty currCountProp = treeTableView.currentItemsCountProperty();
            currCountProp.set(currCountProp.get() - 1);
        });

    }

    private void setupEditableTableView() {
        setupCellValueFactory(firstNameEditableColumn, Person::firstNameProperty);
        setupCellValueFactory(lastNameEditableColumn, Person::lastNameProperty);
        setupCellValueFactory(ageEditableColumn, p -> p.age.asObject());

        // add editors
        firstNameEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        firstNameEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().firstName.set(t.getNewValue());
        });
        lastNameEditableColumn.setCellFactory((TreeTableColumn<Person, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new TextFieldEditorBuilder());
        });
        lastNameEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<Person, String> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().lastName.set(t.getNewValue());
        });
        ageEditableColumn.setCellFactory((TreeTableColumn<Person, Integer> param) -> {
            return new GenericEditableTreeTableCell<>(
                    new IntegerTextFieldEditorBuilder());
        });
        ageEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<Person, Integer> t) -> {
            t.getTreeTableView()
                    .getTreeItem(t.getTreeTablePosition()
                            .getRow())
                    .getValue().age.set(t.getNewValue());
        });

        //final ObservableList<Person> dummyData = generateDummyData(200);
        final ObservableList<Person> dummyData = getData();
        editableTreeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        editableTreeTableView.setShowRoot(false);
        editableTreeTableView.setEditable(true);
        editableTreeTableViewCount.textProperty()
                .bind(Bindings.createStringBinding(() -> PREFIX + editableTreeTableView.getCurrentItemsCount() + POSTFIX,
                        editableTreeTableView.currentItemsCountProperty()));

    }

    private ObservableList<Person> getData(){

        DAOFactory objetoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        IOngDAO ongDAO = objetoFactory.getOngDAO();
        ONG ong = ongDAO.readOngDAO();

        final ObservableList<Person> data = FXCollections.observableArrayList();

        for (Personal instancia: ong.lequipo) {
            data.add(
                    new Person( instancia.getNombre(),
                                instancia.getPrimerApellido(),
                                instancia.getId())
            );
        }
        return data;
    }

    private ObservableList<Person> generateDummyData(final int numberOfEntries) {
        final ObservableList<Person> dummyData = FXCollections.observableArrayList();
        for (int i = 0; i < numberOfEntries; i++) {
            dummyData.add(createNewRandomPerson());
        }
        return dummyData;
    }

    private Person createNewRandomPerson() {
        return new Person(names[random.nextInt(names.length)],
                names[random.nextInt(names.length)],
                random.nextInt(100));
    }

    /*
     * data class
     */
    static final class Person extends RecursiveTreeObject<Person> {
        final StringProperty firstName;
        final StringProperty lastName;
        final SimpleIntegerProperty age;

        Person(String firstName, String lastName, int age) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.age = new SimpleIntegerProperty(age);
        }

        StringProperty firstNameProperty() {
            return firstName;
        }

        StringProperty lastNameProperty() {
            return lastName;
        }
    }
}
