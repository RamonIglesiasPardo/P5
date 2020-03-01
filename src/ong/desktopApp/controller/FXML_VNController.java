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

        import javax.annotation.PostConstruct;
        import java.security.SecureRandom;
        import java.util.Random;
        import java.util.function.Function;

    public class FXML_VNController {

        private static final String PREFIX = "( ";
        private static final String POSTFIX = " )";

        // readonly table view
        @FXML
        private JFXTreeTableView<ong.desktopApp.controller.FXML_VIController.Person> treeTableView;
        @FXML
        private JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, String> firstNameColumn;
        @FXML
        private JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, String> lastNameColumn;
        @FXML
        private JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, Integer> ageColumn;
        @FXML
        private JFXTextField searchField;

        // editable table view
        @FXML
        private JFXTreeTableView<ong.desktopApp.controller.FXML_VIController.Person> editableTreeTableView;
        @FXML
        private JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, String> firstNameEditableColumn;
        @FXML
        private JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, String> lastNameEditableColumn;
        @FXML
        private JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, Integer> ageEditableColumn;
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

        private <T> void setupCellValueFactory(JFXTreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, T> column, Function<ong.desktopApp.controller.FXML_VIController.Person, ObservableValue<T>> mapper) {
            column.setCellValueFactory((TreeTableColumn.CellDataFeatures<ong.desktopApp.controller.FXML_VIController.Person, T> param) -> {
                if (column.validateValue(param)) {
                    return mapper.apply(param.getValue().getValue());
                } else {
                    return column.getComputedValue(param);
                }
            });
        }

        private void setupReadOnlyTableView() {
            setupCellValueFactory(firstNameColumn, ong.desktopApp.controller.FXML_VIController.Person::firstNameProperty);
            setupCellValueFactory(lastNameColumn, ong.desktopApp.controller.FXML_VIController.Person::lastNameProperty);
            setupCellValueFactory(ageColumn, p -> p.age.asObject());

            ObservableList<ong.desktopApp.controller.FXML_VIController.Person> dummyData = generateDummyData(100);

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
            setupCellValueFactory(firstNameEditableColumn, ong.desktopApp.controller.FXML_VIController.Person::firstNameProperty);
            setupCellValueFactory(lastNameEditableColumn, ong.desktopApp.controller.FXML_VIController.Person::lastNameProperty);
            setupCellValueFactory(ageEditableColumn, p -> p.age.asObject());

            // add editors
            firstNameEditableColumn.setCellFactory((TreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, String> param) -> {
                return new GenericEditableTreeTableCell<>(
                        new TextFieldEditorBuilder());
            });
            firstNameEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ong.desktopApp.controller.FXML_VIController.Person, String> t) -> {
                t.getTreeTableView()
                        .getTreeItem(t.getTreeTablePosition()
                                .getRow())
                        .getValue().firstName.set(t.getNewValue());
            });
            lastNameEditableColumn.setCellFactory((TreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, String> param) -> {
                return new GenericEditableTreeTableCell<>(
                        new TextFieldEditorBuilder());
            });
            lastNameEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ong.desktopApp.controller.FXML_VIController.Person, String> t) -> {
                t.getTreeTableView()
                        .getTreeItem(t.getTreeTablePosition()
                                .getRow())
                        .getValue().lastName.set(t.getNewValue());
            });
            ageEditableColumn.setCellFactory((TreeTableColumn<ong.desktopApp.controller.FXML_VIController.Person, Integer> param) -> {
                return new GenericEditableTreeTableCell<>(
                        new IntegerTextFieldEditorBuilder());
            });
            ageEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ong.desktopApp.controller.FXML_VIController.Person, Integer> t) -> {
                t.getTreeTableView()
                        .getTreeItem(t.getTreeTablePosition()
                                .getRow())
                        .getValue().age.set(t.getNewValue());
            });

            final ObservableList<ong.desktopApp.controller.FXML_VIController.Person> dummyData = generateDummyData(200);
            editableTreeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
            editableTreeTableView.setShowRoot(false);
            editableTreeTableView.setEditable(true);
            editableTreeTableViewCount.textProperty()
                    .bind(Bindings.createStringBinding(() -> PREFIX + editableTreeTableView.getCurrentItemsCount() + POSTFIX,
                            editableTreeTableView.currentItemsCountProperty()));

        }



        private ObservableList<ong.desktopApp.controller.FXML_VIController.Person> generateDummyData(final int numberOfEntries) {
            final ObservableList<ong.desktopApp.controller.FXML_VIController.Person> dummyData = FXCollections.observableArrayList();
            for (int i = 0; i < numberOfEntries; i++) {
                dummyData.add(createNewRandomPerson());
            }
            return dummyData;
        }

        private ong.desktopApp.controller.FXML_VIController.Person createNewRandomPerson() {
            return new ong.desktopApp.controller.FXML_VIController.Person(names[random.nextInt(names.length)],
                    names[random.nextInt(names.length)],
                    random.nextInt(100));
        }

        /*
         * data class
         */
        static final class Person extends RecursiveTreeObject<ong.desktopApp.controller.FXML_VIController.Person> {
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
