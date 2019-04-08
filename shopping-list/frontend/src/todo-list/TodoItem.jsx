import React, {Component} from 'react';
import PropTypes from "prop-types";
import Button from "./Button";


export default class TodoList extends Component {

  static propTypes = {
    item: PropTypes.object.isRequired,
    onChange: PropTypes.func,
    onDelete: PropTypes.func
  };

  isCompleteState = () => {
    return this.props.item.state === "COMPLETE";
  };

  changeState = () => {
    if(typeof this.props.onChange === "function" ) {
      let item = {...this.props.item};
      if(this.isCompleteState()){
        item.state = "NEW";
      }else {
        item.state = "COMPLETE";
      }
      this.props.onChange(item);
    }
  };

  changeCount = (elem) => {
    if(typeof this.props.onChange === "function" ) {
      let item = {...this.props.item};
      item.count = elem.target.value;
      this.props.onChange(item);
    }
  };

  delete = () => {
    if(typeof this.props.onDelete === "function" ) {
      this.props.onDelete();
    }
  };

  renderCompleteButton = () => {
    let child;
    if(this.isCompleteState()){
      child = <Button onClick={this.changeState}>Obnov</Button>;
    }else {
      child = <Button onClick={this.changeState}>Dokonči</Button>;
    }
    return child;
  };

  render() {
    return (
        <div className="todo-item">
          {this.props.item.content}
          {this.renderCompleteButton()}
          <Button onClick={this.delete}>Smazat</Button>
          <input type="number" name="quantity" value={this.props.item.count} onChange={this.changeCount} min="1" />
        </div>
    );
  }
}

