package prog2.vista;

import prog2.model.Camping;
import prog2.model.Menu;

/**
 * Classe de vista per a la gestió interactiva del càmping.
 * Controla el menú i delega les operacions al model {@link Camping}.
 *
 * @author Jinjie Chen
 */
public class VistaCamping {
    private Camping camping;

    /**
     * Constructor de la vista.
     *
     * @param nomCamping nom del càmping
     */
    public VistaCamping(String nomCamping){
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    /**
     * Executa el menú principal de l'aplicació i gestiona la interacció amb l'usuari.
     */
    public void gestioCamping(){
        java.util.Scanner sc = new java.util.Scanner(System.in);

        enum OpcionsMenuPrincipal {
            LLISTAR_TOTS_ALLOTJAMENTS,
            LLISTAR_ALLOTJAMENTS_OPERATIUS,
            LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
            LLISTAR_ACCESSOS_OBERTS,
            LLISTAR_ACCESSOS_TANCATS,
            LLISTAR_TASQUES_ACTIVES,
            AFEGIR_TASCA_MANTENIMENT,
            COMPLETAR_TASCA_MANTENIMENT,
            CALCULAR_ACCESSOS_NO_ACCESSIBLES,
            CALCULAR_METRES_ACCESSOS_TERRA,
            GUARDAR_CAMPING,
            RECUPERAR_CAMPING,
            SORTIR
        }

        String[] descMenu = {
                "Llistar la informació de tots els allotjaments",
                "Llistar la informació dels allotjaments operatius",
                "Llistar la informació dels allotjaments no operatius",
                "Llistar la informació dels accessos oberts",
                "Llistar la informació dels accessos tancats",
                "Llistar la informació de les tasques de manteniments actives",
                "Afegir una tasca de manteniment",
                "Completar una tasca de manteniment",
                "Calcular i mostrar el número total d’accessos que NO proporcionen accessibilitat amb vehicle",
                "Calcular i mostrar el número total de metres dels accessos de terra",
                "Guardar càmping",
                "Recuperar càmping",
                "Sortir de l'aplicació"
        };


        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Gestió Càmping Green", OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenu);

        OpcionsMenuPrincipal opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            try {
                switch (opcio) {
                    case LLISTAR_TOTS_ALLOTJAMENTS:
                        System.out.println("=== Allotjaments operatius ===");
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                        System.out.println("=== Allotjaments no operatius ===");
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                        break;

                    case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                        break;

                    case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                        break;

                    case LLISTAR_ACCESSOS_OBERTS:
                        System.out.println(camping.llistarAccessos("Obert"));
                        break;

                    case LLISTAR_ACCESSOS_TANCATS:
                        System.out.println(camping.llistarAccessos("Tancat"));
                        break;

                    case LLISTAR_TASQUES_ACTIVES:
                        System.out.println(camping.llistarTasquesManteniment());
                        break;

                    case AFEGIR_TASCA_MANTENIMENT: {
                        System.out.print("Número de tasca: ");
                        int num = Integer.parseInt(sc.nextLine());

                        System.out.print("ID allotjament (ex: ALL1): ");
                        String idAllotjament = sc.nextLine();

                        System.out.print("Tipus (Reparacio / Neteja / RevisioTecnica / Desinfeccio): ");
                        String tipus = sc.nextLine();

                        System.out.print("Data: ");
                        String data = sc.nextLine();

                        System.out.print("Dies esperats: ");
                        int dies = Integer.parseInt(sc.nextLine());

                        camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);
                        System.out.println("Tasca afegida correctament.");
                        break;
                    }

                    case COMPLETAR_TASCA_MANTENIMENT: {
                        System.out.println("Tasques actives:");
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Número de la tasca a completar: ");
                        int num = Integer.parseInt(sc.nextLine());

                        camping.completarTascaManteniment(num);
                        System.out.println("Tasca completada correctament.");
                        break;
                    }

                    case CALCULAR_ACCESSOS_NO_ACCESSIBLES:
                        System.out.println("Total accessos no accessibles: " + camping.calculaAccessosNoAccessibles());
                        break;

                    case CALCULAR_METRES_ACCESSOS_TERRA:
                        System.out.println("Total metres accessos de terra: " + camping.calculaMetresTerra());
                        break;

                    case GUARDAR_CAMPING: {
                        System.out.print("Ruta fitxer destí: ");
                        String cami = sc.nextLine();
                        camping.save(cami);
                        System.out.println("Càmping guardat correctament.");
                        break;
                    }

                    case RECUPERAR_CAMPING: {
                        System.out.print("Ruta fitxer origen: ");
                        String cami = sc.nextLine();
                        camping = Camping.load(cami);
                        System.out.println("Càmping recuperat correctament.");
                        break;
                    }

                    case SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }
            } catch (ExcepcioCamping e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: format numèric incorrecte.");

            } catch (Exception e) {
                System.out.println("Error inesperat: " + e.getMessage());
            }

        } while (opcio != OpcionsMenuPrincipal.SORTIR);
    }
}
