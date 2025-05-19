Technology-> spring boot version 3.4.5 and java version 17. using architecture microService 

-------------------------Eureka Server----------------------------
|                                                                   |
|                                                                   |
|                                                                   |
|                / --------Service A                                |
|   API GATEWAY /   Hystrix                                         |
|               \                                                   |
|                \ --------Service B                                |
|                                                                   |            
|                                                                   |
|___________________________________________________________________|

hystrix-> Hystrix is a fault tolerance library, especially useful for microservices, that implements the circuit breaker design pattern.


