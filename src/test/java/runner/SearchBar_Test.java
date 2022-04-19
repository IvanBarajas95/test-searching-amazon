package runner;

import com.nivelics.commons.utils.Hooks;
import org.testng.annotations.Test;
import pages.SearchBar;

public class SearchBar_Test extends Hooks {
    ThreadLocal<SearchBar> search = ThreadLocal.withInitial(SearchBar::new);
    @Test
    public void wordsearch(){
        String word = "computadores";
        search.get().searchword(word);
    }
}
