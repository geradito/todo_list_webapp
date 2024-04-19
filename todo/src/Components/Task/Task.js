import React from 'react';
import './Task.css';
import {MdModeEditOutline} from "react-icons/md";
import { MdCancel } from "react-icons/md";
import {MdDone} from "react-icons/md";
import { MdDelete  } from "react-icons/md";

class Task extends React.Component{
    constructor(props){
        super(props);

        this.toggleEditMode = this.toggleEditMode.bind(this);
        this.removeTask = this.removeTask.bind(this);
        this.markDone = this.markDone.bind(this);

        this.state = {
            backgroundColor: '',
            editMode:false
        }
       
    }

    removeTask(){
        this.props.removeTask(this.props.id);
    }

    markDone(){
        if (this.state.backgroundColor === ''){
            this.setState({ backgroundColor: 'rgb(144,238,144, 0.5)' });
        } else {
            this.setState({backgroundColor: ''});
        }
    }

    toggleEditMode(){
        this.setState({editMode : !this.state.editMode})
    }

    editItem(e) {
        if (this._inputElement.value !== "") {
            this.props.text=this._inputElement.value
            this.setState({editMode : !this.state.editMode})
        }
             
        e.preventDefault();
    }

    onTodoChange(value){
        this.setState({
             text: value
        });
    }

    render(){
        return (
            <div className='task-container'>
                <div className='task-container-background' style={{backgroundColor: this.state.backgroundColor}}>
                    <div className='task-term-container'>
                    {this.state.editMode ? (
                            <input className='input' onChange={e => this.setState({ text: e.target.value })} defaultValue ={this.props.text}/>
                        ) : (
                            <h2 className='task-term'>{this.props.text}</h2>
                        )}                    
                    </div>
                    <div className='buttons-container'>
                        <button className='done-button' onClick={this.toggleEditMode}>
                            {this.state.editMode ? (
                                <MdCancel />
                                ) : (
                                    <MdModeEditOutline />
                            )}
                            </button>
                        <button className='done-button' onClick={this.markDone}><MdDone /></button>
                        <button className='delete-button' onClick={this.removeTask}><MdDelete  /></button>
                    </div>
                </div>
            </div>
        );
    }

}

export default Task;