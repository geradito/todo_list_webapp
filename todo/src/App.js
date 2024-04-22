import React from 'react';
import './App.css';
import SubmitForm from './Components/SubmitForm/SubmitForm';
import TasksList from './Components/TasksList/TasksList'

class App extends React.Component{
  constructor(props){
    super(props);
    this.state ={tasks: []}

    this.addTask = this.addTask.bind(this);
    this.removeTask = this.removeTask.bind(this);
  }

  addTask(task){
    this.setState((prevState) => {
      return { 
        tasks: prevState.tasks.concat(task) 
      };
    });
  }

  removeTask(id){
      const tasks = this.state.tasks.filter(element => (element.id !== id));
      this.setState({ tasks: tasks });
  }

  render(){
    return (
      <div className="App">
          <h1>Todo List</h1>
          <h2>Welcome Gerald</h2>
          <SubmitForm addTask={this.addTask}/>
          <TasksList tasks={this.state.tasks} removeTask={this.removeTask}/>
      </div>
    );
  }
}

export default App;
