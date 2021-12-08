/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author OSOMHE
 */
// For a basic sanity check:
public class RandomInputGenerator implements Generator<Input> {
    public Input next() { return Input.randomSelection(); }
}
