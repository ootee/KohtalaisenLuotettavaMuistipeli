
package muistipeli.logiikka;

import java.util.Objects;

public class Kortti {
    private String tunnus;

    public Kortti(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getTunnus() {
        return tunnus;
    }

    @Override
    public String toString() {
        return tunnus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.tunnus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kortti other = (Kortti) obj;
        if (!Objects.equals(this.tunnus, other.tunnus)) {
            return false;
        }
        return true;
    }
    
    
}
