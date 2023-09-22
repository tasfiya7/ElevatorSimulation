The purpose of this program is to perform simulation of a building's elevator system that processes passenger requests. You will need to input parameters to the simulation representing the number of floors in the building, the number of elevators, the simulation length in time units, and the percent chance that a passenger will place a new elevator request during each time unit. The following list of details further describes how the simulation will be run:

There will be one queue of requests for the simulation. The queue is a standard FIFO queue, meaning that the first request placed is the first to be granted.

Each elevator can only handle one passenger at a time.

#A single time unit represents the amount of time it takes for the elevator to move up or down one floor.

#At the beginning of each time unit, there is a random chance that a new request will be placed by a passenger. There may be at most one new request placed per time unit. 

Requests have a randomly generated source floor (where the passenger is) and destination floor (where the passenger wishes to go).

#After checking for a possible new request, all elevators that are currently idle (i.e., not handling a request) will be given a request to handle, if such a request exists. It does not matter which elevator is assigned to handle a request.

#At the end of each time unit, all elevators that are processing requests move one floor closer to completing the request. If the elevator was moving to pick up a passenger, the elevator will move one floor closer to the source floor. If the elevator was moving to drop off the passenger, it will move one floor closer to the destination floor.

#If the source floor is reached, the elevator will begin heading towards the destination floor on the next time unit.

#If the destination floor is reached, the elevator will then be marked as idle (on the next time step, it can handle a new request).

#If an elevator just begins handling a request on the current time unit and if it was already on the source floor, it may begin moving towards the destination on the current time step.

#If an elevator is on the source floor and if the source floor is also the destination floor, the elevator may be set to idle (it has reached its destination and can handle a new request on the next time unit).

#The task is to calculate the average waiting time for requests.

#Wait time is defined as the number of time units that pass from when a request is placed on the queue until the elevator picks up the passenger (i.e., until the elevator arrives at the source floor).

#The program will add the amount of waiting time for a request to the waiting sum and increment the request count as each request has its elevator reach its source floor.
In  calculations,  all requests that have not had an assigned elevator reach its source floor will be ignored.

Note: When an elevator has reached the source floor of the request it is handling, the waiting time officially ends. The time it takes the elevator to reach the destination is not counted.
