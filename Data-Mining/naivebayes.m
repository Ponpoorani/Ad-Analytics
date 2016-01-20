function [class] = naivebayes(X, Y, test)

model = NaiveBayes.fit(X, Y,'Distribution', 'mn');
class = predict(model,test);

end
