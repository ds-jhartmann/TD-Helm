# TD-Helm

Example project for a helm chart of a spring application

## Setup

- [Helm quickstart](https://helm.sh/docs/intro/quickstart/)
- [Kubernetes quickstart](https://kubernetes.io/de/docs/setup/)
- [ArgoCD quickstart](https://argo-cd.readthedocs.io/en/stable/getting_started/)

#### Start Cluster
```bash
minikube start
```
#### Cluster Dashboard
```bash
minikube dashboard
```

```bash
k9s -A
```

#### Setup ArgoCD
```bash
helm repo add argo https://argoproj.github.io/argo-helm
```
```bash
helm install argocd argo/argo-cd -n argocd --create-namespace
```
```bash
kubectl create namespace td-dev
```
##### Get Argo Admin secret
```shell
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
```
#### Install Chart
```bash
helm install test charts/simple-spring-app -n test --create-namespace
```
#### Test Chart
```bash
helm test test -n test
```
#### Uninstall Chart
```bash
helm uninstall test -n test
```

## Helm Docs

```shell
docker run --rm --volume "$(pwd):/helm-docs" jnorwood/helm-docs:latest
```