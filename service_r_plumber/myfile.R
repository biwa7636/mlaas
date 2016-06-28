library(e1071)

# load the iris dataset and use it to train a support vector machine to predict species
data("iris")
model <- svm(data=iris, Species ~ .)

#* @post /predict
predict_iris <- function(sl="1", sw="2", pl="3", pw="4"){
  ptm <- proc.time()
  sl <- as.numeric(sl)
  sw <- as.numeric(sw)
  pl <- as.numeric(pl)
  pw <- as.numeric(pw)
  prediction <- predict(model, data.frame("Sepal.Length"=sl,"Sepal.Width"=sw,"Petal.Length"=pl, "Petal.Width"=pw))
  result <- data.frame(prediction=prediction, status="success", timetaken=(proc.time()-ptm)['elapsed'])
}

#* @get /
index <- function(){
  data.frame(status="success", uptime=proc.time()['elapsed'])
}
