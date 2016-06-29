library(h2o)

localH2O <- h2o.init(ip = 'localhost', port = 54321)
h2o.clusterInfo(localH2O)
# TODO: not hard coding
iris <- h2o.importFile(path = "/Users/a59347/Desktop/mlaas/service_h2o_pojo/ml/iris.csv")
prostate.km <- h2o.kmeans(training_frame = iris, k = 3, x=c("sepal_length","sepal_width","petal_length","petal_width"))

# predict for testing
new.data <- data.frame("sepal_length"=10,"sepal_width"=10,"petal_length"=10, "petal_width"=10)
h2o.predict(object = prostate.km, newdata = as.h2o(new.data))

# TODO: not hard coding 
h2o.download_pojo(model=prostate.km, path="/Users/a59347/Desktop/mlaas/service_h2o_pojo/ml/")
