package pl.lendemark.springbootvadin.view;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lendemark.springbootvadin.PokemonDeck;
import pl.lendemark.springbootvadin.model.Pokemon;
import pl.lendemark.springbootvadin.model.PokemonType;

import java.util.List;
import java.util.stream.Collectors;

@Route("Zobacz liste pokemonow")
public class PokemonDeckGui extends VerticalLayout {

    @Autowired
    public PokemonDeckGui(PokemonDeck pokemonDeck) {

        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<>("Pokemon Type:", PokemonType.values());


        pokemonTypeComboBox.addValueChangeListener(click -> {

            Grid<Pokemon> grid = new Grid<>(Pokemon.class);
            List<Pokemon> pokemonList = pokemonDeck.getPokemons();
            List<Pokemon> collect = pokemonList.stream()
                    .filter(pokemon -> pokemon.getPokemonType() == pokemonTypeComboBox.getValue())
                    .collect(Collectors.toList());

            grid.removeColumnByKey("image");
            grid.setItems(pokemonDeck.getPokemons());
            grid.addColumn(new ComponentRenderer<>(pokemon -> {
                Image image = new Image(pokemon.getImage(), pokemon.getImage());
                return image;
            }));

            add(grid);

        });

        add(pokemonTypeComboBox);


    }
}
