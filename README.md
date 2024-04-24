# TD-Helm

example project for a helm chart

## TODO 
- best/bad practices 
- eigene helpers
- custom secrets

## Setup
```bash
minikube start
```
```bash
helm repo add argo https://argoproj.github.io/argo-helm
```
```bash
helm install argocd argo/argo-cd -n argocd --create-namespace
```
```bash
kubectl create namespace td-dev
```
```shell
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
```

