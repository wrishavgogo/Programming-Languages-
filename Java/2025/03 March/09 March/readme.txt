While doing a question where i was using switch case in java 


i had a counter++;


while(condition) {

  counter++;

  switch(counter) {
    case 1 : {
      }
    default : {
    }
  }

  the problem that i was facing is both the part of code was getting executed, 

My mistake ?

  I realised default will be executed always unless i apply a break condition . 
  so missed a break condition in case one and suffered the consequence
