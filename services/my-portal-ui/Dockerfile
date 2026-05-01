FROM node:10-alpine AS deps
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install --no-audit --no-progress

FROM node:10-alpine
WORKDIR /app
COPY --from=deps /app/node_modules ./node_modules
COPY . .
ENV PATH=/app/node_modules/.bin:$PATH
EXPOSE 4200
ENTRYPOINT ["ng", "serve", "--host", "0.0.0.0", "--port", "4200", "--disable-host-check"]
