package DesignPatterns;

/*
 * Creational design pattern
 * Only one instance should exist - other classes should be able to get the instance of the class
 * Used in cache, logging, drivers, session
 * Constructor should be private and public method for returning private
 * 
 * Initialization types:
 * Eager Initialization - when we are defining the variable at the same time we are declaring it
 * Lazy Initialization - whenever there is a need / call, then only it will create an instance
 * Thread safe method initialization - only one user can access the instance at the same time, we make the method synchronized
 * thread safe block initialization - synchronizing only the instance block : for example, read method access is allowed for all but write instance is synchronized
 * 
 * 
 */

public class Singleton {

}
