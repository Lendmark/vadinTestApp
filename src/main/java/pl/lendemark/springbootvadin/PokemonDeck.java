package pl.lendemark.springbootvadin;

import org.springframework.stereotype.Repository;
import pl.lendemark.springbootvadin.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonDeck {

    private List<Pokemon> pokemons;

    public PokemonDeck(){
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "PokemonDeck{" +
                "pokemons=" + pokemons +
                '}';
    }
}
