package prog2.model;

import java.util.Scanner;

public interface InClient {

    public String getNom();

    public String getDni();

    public void setNom(String nom);

    public void setDni(String dni);


    /**
     * Exemple d'utilització de la classe Menu.
     *
     */
    class ExempleMenu {

        // Declarem les opcions per a referir-se a les opcions del menú.
        static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,MENU_PRINCIPAL_SUBMENU1,MENU_PRINCIPAL_SORTIR};
        static private enum OpcionsSubmenu1 {MENU_S1_OPCIO1,MENU_S1_OPCIO2,MENU_S1_SORTIR};

        // Declarem descripcions personalitzades per a les opcions del menú principal
        static private String[] descMenuPrincipal={"Primera opció del menú principal",
                                                   "Segona opció del menú principal",
                                                   "Obre un menú secundari",
                                                   "Sortir de l'aplicació"};

        // Declarem descripcions personalitzades per a les opcions del menú secundari
        static private String[] descMenu2={"Primera Opció del menú secundari",
                                                    "Segona Opció del menú secundari",
                                                    "Menú anterior"};

        /**
         * Fitxer principal. Crea el menú principal i un menú secundari
         * @param args valor d'entrada associat a l'operació
         */
        public static void main(String[] args) {
            // Creem un objecte per llegir des del teclat
            Scanner sc=new Scanner(System.in);

            // Creem un objecte principal
            ExempleMenu app = new ExempleMenu();

            // Iniciem la gestió del menú principal de l'aplicació
            app.gestio(sc);
        }

        /**
         * Menú principal del reproductor d'audio
         * @param sc valor d'entrada associat a l'operació
         */
        private void gestio(Scanner sc) {

            // Creem l'objecte per al menú. Li passem com a primer parà metre el nom del menú
            Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal",OpcionsMenuPrincipal.values());

            // Assignem la descripció de les opcions
            menu.setDescripcions(descMenuPrincipal);

            // Obtenim una opció des del menú i fem les accions pertinents
            OpcionsMenuPrincipal opcio = null;
            do {
                // Mostrem les opcions del menú
                menu.mostrarMenu();

                // Demanem una opcio
                opcio=menu.getOpcio(sc);

                // Fem les accions necessÃ ries
                switch(opcio) {
                    case MENU_PRINCIPAL_OPCIO1:
                        // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                        System.out.println("Has triat la opciÃ³ 1");
                        break;
                    case MENU_PRINCIPAL_OPCIO2:
                        // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                        System.out.println("Has triat la opciÃ³ 2");
                        break;
                    case MENU_PRINCIPAL_SUBMENU1:
                        // Cridem el métode de gestió del menú secundari
                        gestioMenuSecundari(sc);
                        break;

                    case MENU_PRINCIPAL_SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }

            } while(opcio!=OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
        }

        /**
         * Menú secundari
         * @param sc valor d'entrada associat a l'operació
         */
        private void gestioMenuSecundari(Scanner sc) {

            // Creem l'objecte per al menú. Li passem com a primer parÃ metre el nom del menú
            Menu<OpcionsSubmenu1> menu=new Menu<OpcionsSubmenu1>("Menu Secundari",OpcionsSubmenu1.values());

            // Assignem la descripció de les opcions
            menu.setDescripcions(descMenu2);

            // Obtenim una opció des del menú i fem les accions pertinents
            OpcionsSubmenu1 opcio = null;
            do {
                // Mostrem les opcions del menú
                menu.mostrarMenu();

                // Demanem una opcio
                opcio=menu.getOpcio(sc);

                // Fem les accions necessàries
                switch(opcio) {
                    case MENU_S1_OPCIO1:
                        // Mostrem un missatge indicant que s'ha triat aquesta opció
                        System.out.println("Has triat la opciÃ³ 1");
                        break;
                    case MENU_S1_OPCIO2:
                        // Mostrem un missatge indicant que s'ha triat aquesta opció
                        System.out.println("Has triat la opciÃ³ 2");
                        break;
                    case MENU_S1_SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }

            } while(opcio!=OpcionsSubmenu1.MENU_S1_SORTIR);
        }

    }
}
