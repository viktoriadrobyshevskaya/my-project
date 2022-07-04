package by.epam.drobyshevskaya.project.service.factory;

import by.epam.drobyshevskaya.project.service.ClientService;
import by.epam.drobyshevskaya.project.service.LibraryService;
import by.epam.drobyshevskaya.project.service.impl.ClientServiceImpl;
import by.epam.drobyshevskaya.project.service.impl.LibraryServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();
    private final LibraryService libraryService = new LibraryServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }
}
