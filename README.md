# Shopify Merchant App
---

An Android application for Shopify merchants that allows you to view:
 - Total sales of your favourite customer
 - Total quantity of a particular item sold
 
### Architecture

![alt text](https://cms-assets.tutsplus.com/uploads/users/1308/posts/26206/image/MVP-Android.png)

  - **Seperation of concerns** : MVP provides a layer of abstraction between the business logic (presenter), view logic (activity,fragment etc.) and the data (models) so that they are independent of one another.
  - **Testing** : Because the presenter, view, and model are independent and interact via interfaces they can be tested independently by examining the data that is passed between the interfaces.


#### Key Components:

  - **Models** :
    * AllOrders
    * Order
    * LineItem
    * Customer
  - **Presenters** : 
    * MainPresenter
  - **Views** : 
    * MainActivity
  - **Contracts** : 
    * MainContract

### POJO & Models
This app maps JSON objects returned by the API to POJOs. Some advantages:
-  Typesafety 
-  Compile time checking

However, POJOs cannot be passed directly to another server or process not implemented in Java, they have to be [serialized](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html) and [deserialized](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html). If in the future we are required to communicate back and forth with a server a better alternative would be to implement our DTOs (Data Transfer Object) using something like [Protocol Buffers](https://github.com/google/protobuf) and leverage the convenience of platform independence among other advantages.
### Dependencies

[Dagger](https://github.com/google/dagger) is used for dependency injection. Some advantages: 
 -  Allows us to avoid inversion-of-control.
 -  Allows us to swap out dependencies easily for testing.
 -  Allows us to control the scope and lifetime of these dependencies.

### Network Calls

[Retrofit](https://github.com/square/retrofit) is the http client client used in this application. Some advantages:
 - Allows seperation of concerns as the implementation is based on designing interfaces.
 - Allows us to produce fake implementations of the interface when testing and make the tests independent of network requests. 
 - Supports RxJava very well as the interface methods are allowed to return Observables.

### Asynchronous Framework

[RxJava](https://github.com/ReactiveX/RxJava) is the framework used to simplify asynchronous programming. Based on the nature of this app which requires us to fetch a list of objects and perform filter-map-reduce operations RxJava and a functional approach seemed appropriate. Some advantages:

- Allows us to simplify the ability to chain async operations and avoid layered callbacks.
- Allows good error handling as errors from these chained async operations are caught in one place.
- Allows us to avoid keeping track of state variables and associated bugs as we are thinking about how data flows and modifying the streams of data using a functional approach.

### Testing

[Mockito](https://github.com/mockito/mockito) and [Robolectric](https://github.com/robolectric/robolectric) are used to help test the application. Some advantages:

- Mockito allows us to easily mock the contracts between the views and presenters and validate the data
passed through the contract methods.
- Robolectric allows us to detach the Android SDK jar from the app so that the tests can be 
run on a regular JVM.
