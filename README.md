Initial Fix is having microservices communicating in local without docker & kubernates

Second push having required changes to deploy microservices in kubernetes.

Create docker files in project. then run below command.

docker login
mvn clean package dockerfile:push

kubectl apply -f ./service-registry.yml
kubectl apply -f ./
kubectl get deployments
kubectl get svc
kubectl get pods
kubectl get all
minikube service list
minikube addons enable metrics-server

>kubectl scale --replicas=3 .\employee-service.yml
>minikube dashboard

run below command on folder where were k8s yml files to delete 
>kubectl delete -f ./
