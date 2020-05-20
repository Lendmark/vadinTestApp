package pl.lendemark.springbootvadin.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lendemark.springbootvadin.PokemonDeck;
import pl.lendemark.springbootvadin.model.Pokemon;
import pl.lendemark.springbootvadin.model.PokemonType;



@Route("Dodaj Pokemona")
public class PokemonAdderGui extends VerticalLayout {

    @Autowired
    public PokemonAdderGui(PokemonDeck pokemonDeck) {

        TextField textFieldName = new TextField("Name");
        TextField textFieldImage = new TextField("image");
        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<>("Pokemon Typ:", PokemonType.values());
        Button buttonAdd = new Button("Add new Pokemon!");

        buttonAdd.addClickListener(buttonClickEvent -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(textFieldName.getValue());
            pokemon.setImage(textFieldImage.getValue());
            pokemon.setPokemonType(pokemonTypeComboBox.getValue());
            pokemonDeck.getPokemons().add(pokemon);
            Notification notification = new Notification("Pokemon Added!", 3000);
            notification.open();
        });

        add(textFieldName, textFieldImage, pokemonTypeComboBox , buttonAdd);

    }
}
