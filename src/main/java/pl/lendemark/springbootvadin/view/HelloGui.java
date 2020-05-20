package pl.lendemark.springbootvadin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello") // ta adnotacje dodajemy gdy chcemy użyć vadina - mówi nam że ta klasa jest zarządzana przez context vadina
@StyleSheet("/css/style.css") // podajemy adres gdzie mamy naszego css którego chcemy wstrzyknąć
public class HelloGui extends VerticalLayout { // vertical to ustawienie jednego pod drugik horizontal to jednego obok drugiego



    public HelloGui() {
        TextField textFieldName = new TextField("Podaj imie");
        Button buttonName = new Button("Button", new Icon(VaadinIcon.ACADEMY_CAP));
        Label labelName = new Label();

        buttonName.addClickListener(buttonClickEvent -> {
            labelName.setText("Hello " + textFieldName.getValue());
            add(new Image("https://media.tenor.com/images/1170597818a37a7c6e3e1d4baeb6e2eb/tenor.gif", "nie ma :("));

        });



        add(textFieldName, buttonName, labelName);
    }
}
