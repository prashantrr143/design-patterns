# Decorator Design Pattern

## Intent

Attach additional responsibility to an object dynamically.Decorators provide a flexible alternative to sub-classing for extending functionality.

Sometimes we want to add responsibilities to individual objects ,not an entire class.	Instead of inheriting functionality from base class , functionality can be extended using composition.
	
Idea is to create an object (Decorator) which encloses the target object.The decorator	forwards the request to the component and may perform additional actions(extending the base functionality) before and after forwarding. 
	
The Decorator conforms to the interface of the component it decorates, so that it's presence is transparent to component's clients.
	
----
	
### Components Involved

| Name              	| Usage                                                                                                         	|
|-------------------	|---------------------------------------------------------------------------------------------------------------	|
| Component         	| Defines the interface for the objects that can have responsibilities added to them dynamically.               	|
| ConcreteComponent 	| Defines an object to which additional responsibilities can be attached                                        	|
| Decorator         	| Maintains a reference to the Component Object and defines an interface that conforms to Component's interface 	|
| ConcreteDecorator 	| Adds responsibilities to the component                                                                        	|