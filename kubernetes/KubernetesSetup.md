# Robot Apocalypse on Kubernetes

In order to get the application up and running on Kubernetes you need to perform the following steps. This has been
tested on minikube.

### 1. Infrastructure

Create Postgress Databases for Survivor Service and Report Service:

```
kubectl create -f infrastructure/postgress-survivor-service.yaml

kubectl create -f infrastructure/postgress-report-service.yaml
```

Create Redis Deployment and Service used by Robot Microservice:

```
kubectl create -f infrastructure/redis.yaml

```

### 2. Create Services

```
kubectl create -f services/survivor-service.yaml

kubectl create -f services/report-service.yaml

kubectl create -f services/robot-service.yaml
```

### 3. Create ConfigMaps

Wait for the Services to get public URLs and then look them up in order to create three ConfigMaps:

```
kubectl create configmap survivor-config --from-literal=nextProcessStepUrl=[SURVIVOR-URL]/survivor/

kubectl create configmap report-config --from-literal=nextProcessStepUrl=[REPORT-URL]/report/

kubectl create configmap report-config --from-literal=nextProcessStepUrl=[ROBOT-URL]/robot/

```
### 4. Create Deployments

```
kubectl create -f deployments/survivor-deployment.yaml

kubectl create -f deployments/robot-deployment.yaml

kubectl create -f deployments/report-deployment.yaml

```

## Access to the Application
Lookup the URL + Port of each microservice and access it.
