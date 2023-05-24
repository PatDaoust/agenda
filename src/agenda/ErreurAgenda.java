/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author catal
 */
public class ErreurAgenda extends Exception {

    public ErreurAgenda() {
        super();
    }

    // Overrides Exception's getMessage()
    @Override
    public String getMessage() {
        return "Aucun evenment existe a ce temps";
    }

}
