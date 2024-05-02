import { Client, Variables, logger } from "camunda-external-task-client-js";

// configuration for the Client:
//  - 'baseUrl': url to the Process Engine
//  - 'logger': utility to automatically log important events
const config = { baseUrl: "http://localhost:8082/engine-rest", use: logger };

// create a Client instance with custom configuration
const client = new Client(config);


client.subscribe("sendStatusCanceled", async function({ task, taskService }) {
  console.log(task, taskService)
  const processVariables = new Variables();
  processVariables.set("summary", "La solicitud ha sido cancelada, no se enviaron los documentos a tiempo")
  await taskService.complete(task, processVariables);
});
client.subscribe("sendStatusRejected", async function({ task, taskService }) {
  console.log(task, taskService)
  const processVariables = new Variables();
  processVariables.set("summary", "La solicitud ha sido rechazada porque no cumple con los requisitos para solicitar el credito")
  await taskService.complete(task, processVariables);
});